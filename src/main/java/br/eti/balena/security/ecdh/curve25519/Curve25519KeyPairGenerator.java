package br.eti.balena.security.ecdh.curve25519;

import java.security.KeyPair;
import java.security.SecureRandom;

import static br.eti.balena.security.ecdh.curve25519.Curve25519.KEY_SIZE;

public class Curve25519KeyPairGenerator {
    private SecureRandom mSecureRandom;

    public Curve25519KeyPairGenerator() {
        this(new SecureRandom());
    }

    public Curve25519KeyPairGenerator(SecureRandom secureRandom) {
        mSecureRandom = secureRandom;
    }

    public KeyPair generateKeyPair() {
        byte[] privateKey = new byte[KEY_SIZE];
        mSecureRandom.nextBytes(privateKey);

        byte[] publicKey = new byte[KEY_SIZE];
        byte[] s = new byte[KEY_SIZE];
        Curve25519.keygen(publicKey, s, privateKey);

        return new KeyPair(new Curve25519PublicKey(publicKey),
                new Curve25519PrivateKey(privateKey));
    }
}
