package br.eti.balena.security.ecdh.curve25519;

import java.security.PrivateKey;

public final class Curve25519PrivateKey extends Curve25519Key implements PrivateKey {
    public Curve25519PrivateKey(byte[] key) {
        super(key);
    }
}
