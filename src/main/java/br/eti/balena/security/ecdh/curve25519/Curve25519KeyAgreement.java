package br.eti.balena.security.ecdh.curve25519;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;

import static br.eti.balena.security.ecdh.curve25519.Curve25519.ALGORITHM;
import static br.eti.balena.security.ecdh.curve25519.Curve25519.KEY_SIZE;

public class Curve25519KeyAgreement {
    private byte[] mPrivateKey;
    private byte[] mSharedSecret;

    public Curve25519KeyAgreement(PrivateKey key) throws InvalidKeyException {
        if (!(key instanceof Curve25519PrivateKey)) {
            throw new InvalidKeyException(ALGORITHM
                    + " key agreement requires "
                    + Curve25519PrivateKey.class.getSimpleName() + " for initialization");
        }
        mPrivateKey = key.getEncoded();
    }

    public void doFinal(PublicKey key) throws InvalidKeyException {
        if (!(key instanceof Curve25519PublicKey)) {
            throw new InvalidKeyException(ALGORITHM
                    + " key agreement requires "
                    + Curve25519PublicKey.class.getSimpleName() + " for doFinal");
        }
        mSharedSecret = new byte[KEY_SIZE];
        Curve25519.curve(mSharedSecret, mPrivateKey, key.getEncoded());
    }

    public byte[] generateSecret() throws IllegalStateException {
        byte[] sharedSecret = new byte[KEY_SIZE];
        try {
            generateSecret(sharedSecret, 0);
        } catch (ShortBufferException e) {
            e.printStackTrace();
        }
        return sharedSecret;
    }

    public int generateSecret(byte[] bytes, int i)
            throws IllegalStateException, ShortBufferException {
        if (bytes.length - i < KEY_SIZE)
            throw new ShortBufferException();
        System.arraycopy(mSharedSecret, 0, bytes, i, KEY_SIZE);
        return KEY_SIZE;
    }

    public SecretKey generateSecret(String algorithm)
            throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        if (!algorithm.equals(ALGORITHM))
            throw new NoSuchAlgorithmException("Unknown algorithm encountered: " + algorithm);
        return new Curve25519SecretKey(generateSecret());
    }
}
