package nl.ben221199.wapi;

import com.google.protobuf.ByteString;
import com.southernstorm.noise.protocol.HandshakeState;
import com.whatsapp.proto.WA4Protos;
import nl.ben221199.wapi.fun.FunXMPP;

import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandshakeManager {
    private HandshakeState handshake;

    private void createHandshakeState(String protocol){
        try{
            this.handshake = new HandshakeState(protocol,HandshakeState.INITIATOR);
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    private void writeWhatsAppHeader(FunOutputStream out) throws IOException{
        byte[] WA = {(byte)'W',(byte)'A',(byte) Constants.Protocol.MAJOR,(byte) Constants.Protocol.MINOR};
        this.handshake.setPrologue(WA,0,WA.length);
        out.write(WA);
        out.flush();
        FunXMPP.setVersion(Constants.Protocol.FUN_VERSION);
    }

    public  Map<String, Object> doHandshakeXX(FunInputStream in, FunOutputStream out, KeyPair s, WA4Protos.ClientPayload clientPayload) throws IOException{
        this.createHandshakeState("Noise_XX_25519_AESGCM_SHA256");
        if(this.handshake==null){
            throw new IOException("Handshake should not be null");
        }
        writeWhatsAppHeader(out);
        if(this.handshake.needsLocalKeyPair()){
//			this.handshake.getLocalKeyPair().setPublicKey(this.s.getPublic().getEncoded(),0);
            this.handshake.getLocalKeyPair().setPrivateKey(s.getPrivate().getEncoded(),0);
        }
        this.handshake.start();
        System.out.println("Handshake started");

        System.out.println("Sending CLIENT HELLO: e");
        byte[] clientHello = this.writeHandshakeMessage(new byte[0]);
        byte[] client_hello_ephemeral = Arrays.copyOfRange(clientHello,0,32);
        WA4Protos.HandshakeMessage.ClientHello client_hello = WA4Protos.HandshakeMessage.ClientHello.newBuilder().setEphemeral(ByteString.copyFrom(client_hello_ephemeral)).build();
        WA4Protos.HandshakeMessage client_hello_message = WA4Protos.HandshakeMessage.newBuilder().setClientHello(client_hello).build();
        out.writeSegment(client_hello_message.toByteArray());
        out.flush();
        System.out.println("Sent CLIENT HELLO");

        System.out.println("Receiving SERVER HELLO: e, ee, s, es");
        byte[] server_hello_data = in.readSegment();
        WA4Protos.HandshakeMessage server_hello_message = WA4Protos.HandshakeMessage.parseFrom(server_hello_data);
        if(!server_hello_message.hasServerHello()){
            System.err.println("Doesn't have server hello");
            return null;
        }
        WA4Protos.HandshakeMessage.ServerHello server_hello = server_hello_message.getServerHello();
        byte[] server_hello_buffer = server_hello.getEphemeral().concat(server_hello.getStatic().concat(server_hello.getPayload())).toByteArray();
        byte[] serverHello = this.readHandshakeMessage(server_hello_buffer);
        WA4Protos.NoiseCertificate noiseCertificate = WA4Protos.NoiseCertificate.parseFrom(serverHello);
        boolean isValid = CertificateChecker.check(noiseCertificate,this.handshake.getRemotePublicKey());
        System.out.println("Received SERVER HELLO: Certificate is"+(isValid?"":" NOT")+" valid.");

        System.out.println("Sending CLIENT FINISH: s, se");
        byte[] clientFinish = this.writeHandshakeMessage(clientPayload.toByteArray());


//		System.out.println("<> "+bytesToHex(buffer2));

        byte[] staticBytes = ByteString.copyFrom(clientFinish).substring(0,48).toByteArray();
        byte[] payloadBytes = ByteString.copyFrom(clientFinish).substring(48,clientFinish.length).toByteArray();

        WA4Protos.HandshakeMessage.ClientFinish client_finish = WA4Protos.HandshakeMessage.ClientFinish.newBuilder()
                .setStatic(ByteString.copyFrom(staticBytes))
                .setPayload(ByteString.copyFrom(payloadBytes))
                .build();
        byte[] buf = new byte[32];
        this.handshake.getLocalKeyPair().getPublicKey(buf,0);
        WA4Protos.HandshakeMessage client_finish_message = WA4Protos.HandshakeMessage.newBuilder().setClientFinish(client_finish).build();
        out.writeSegment(client_finish_message.toByteArray());
        out.flush();
        System.out.println("Sent CLIENT FINISH");

        Map<String, Object> values = new HashMap<>();
        values.put("out", out);
        values.put("clientPayload", clientPayload);
        values.put("s", s);
        return values;
    }

    public void doHandshakeIK() throws IOException{}

    public void doHandshakeXXfallback() throws IOException{}

    public void checkSplitState() throws IOException {
        if(this.handshake.getAction()!=HandshakeState.SPLIT){
            throw new IOException("Handshake should be in split state");
        }
    }

    public com.southernstorm.noise.protocol.CipherStatePair handshakeSplit(){
       return this.handshake.split();
    }

    private byte[] readHandshakeMessage(byte[] data){
        byte[] buffer = new byte[data.length+1024];
        int length = 0;
        try{
            length = this.handshake.readMessage(data,0,data.length,buffer,0);
        }catch(BadPaddingException | ShortBufferException e){
            e.printStackTrace();
        }
        if(length==0){
            return new byte[0];
        }
        if(length==buffer.length){
            return buffer;
        }
        byte[] result = new byte[length];
        System.arraycopy(buffer,0,result,0,length);
        return result;
    }

    private byte[] writeHandshakeMessage(byte[] data){
        byte[] buffer = new byte[data.length+1024];
        int length = 0;
        try{
            length = this.handshake.writeMessage(buffer,0,data,0,data.length);
        }catch(ShortBufferException e){
            e.printStackTrace();
        }
        if(length==0){
            return new byte[0];
        }
        if(length==buffer.length){
            return buffer;
        }
        byte[] result = new byte[length];
        System.arraycopy(buffer,0,result,0,length);
        return result;
    }

    public void setNull() {
        this.handshake=null;
    }
}
