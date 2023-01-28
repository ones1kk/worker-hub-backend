package com.breakingbad.workerhub.core.crypto;

public interface Crypto {

    String encrypt(String text);

    String decrypt(String cipherText);
}
