import nl.ben221199.wapi.JSONSignalStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.whispersystems.libsignal.*;
import org.whispersystems.libsignal.state.IdentityKeyStore;
import org.whispersystems.libsignal.ecc.ECPublicKey;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JSONSignalStoreTest {

    private JSONSignalStore signalStore;

    @BeforeEach
    public void setUp() {
        signalStore = new JSONSignalStore();
    }

    @Test
    public void testSaveIdentity() {
        SignalProtocolAddress address = new SignalProtocolAddress("alice", 1);
        // Create a mock ECPublicKey
        ECPublicKey publicKey = mock(ECPublicKey.class);
        IdentityKey identityKey = new IdentityKey(publicKey);

        boolean saved = signalStore.saveIdentity(address, identityKey);


        IdentityKey retrievedIdentity = signalStore.getIdentity(address);
        assertEquals(identityKey, retrievedIdentity);
    }

    @Test
    public void testIsTrustedIdentityWhenIdentityIsNotPresent() {
        SignalProtocolAddress address = new SignalProtocolAddress("bob", 1);
        // Create a mock ECPublicKey
        ECPublicKey publicKey = mock(ECPublicKey.class);
        IdentityKey identityKey = new IdentityKey(publicKey);

        boolean isTrusted = signalStore.isTrustedIdentity(address, identityKey, IdentityKeyStore.Direction.SENDING);

        assertTrue(isTrusted);
    }

    @Test
    public void testIsTrustedIdentityWhenIdentityIsPresent() {
        SignalProtocolAddress address = new SignalProtocolAddress("alice", 1);
        // Create a mock ECPublicKey
        ECPublicKey publicKey = mock(ECPublicKey.class);
        IdentityKey identityKey = new IdentityKey(publicKey);
        signalStore.saveIdentity(address, identityKey);

        boolean isTrusted = signalStore.isTrustedIdentity(address, identityKey, IdentityKeyStore.Direction.RECEIVING);

        assertTrue(isTrusted);
    }

    @Test
    public void testIsTrustedIdentityWhenIdentityIsNotTrusted() {
        SignalProtocolAddress address = new SignalProtocolAddress("alice", 1);
        // Create mock ECPublicKey instances
        ECPublicKey publicKey1 = mock(ECPublicKey.class);
        ECPublicKey publicKey2 = mock(ECPublicKey.class);

        // Create IdentityKey instances using different ECPublicKeys
        IdentityKey storedIdentity = new IdentityKey(publicKey1);
        IdentityKey newIdentity = new IdentityKey(publicKey2);

        signalStore.saveIdentity(address, storedIdentity);

        boolean isTrusted = signalStore.isTrustedIdentity(address, newIdentity, IdentityKeyStore.Direction.RECEIVING);

        assertFalse(isTrusted);
    }

}

