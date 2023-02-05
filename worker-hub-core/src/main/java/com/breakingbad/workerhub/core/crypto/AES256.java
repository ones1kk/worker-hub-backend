package com.breakingbad.workerhub.core.crypto;

import com.breakingbad.workerhub.exception.EncryptException;
import io.github.ones1kk.assertion.core.Asserts;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import static com.breakingbad.workerhub.constant.Algorithm.AES;
import static com.breakingbad.workerhub.constant.Algorithm.AES_CBC_PKCS5PADDING;


public class AES256 implements Crypto {

    private final Key key;

    private final AlgorithmParameterSpec algParamSpec;

    public AES256(String key) {
        Asserts.that(key)
                .isNotNull().hasText().asLength()
                .as("16자리 문자가 와야합니다. key: '{}'", key)
                .isEqualTo(16);

        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);

        this.key = new SecretKeySpec(bytes, AES.getValue());
        this.algParamSpec = new IvParameterSpec(bytes);
    }

    @Override
    public String encrypt(String text) {
        try {
            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING.getValue());
            cipher.init(Cipher.ENCRYPT_MODE, key, algParamSpec);

            byte[] encrypted = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
    }

    @Override
    public String decrypt(String cipherText) {
        try {
            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING.getValue());
            cipher.init(Cipher.DECRYPT_MODE, key, algParamSpec);

            byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
            byte[] decrypted = cipher.doFinal(decodedBytes);

            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
    }
}
