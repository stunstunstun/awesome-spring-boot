package com.stunstun.spring;


import org.assertj.core.util.Lists;
import org.junit.Test;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
public class SecurityTests {

    @Test
    public void generateKeyPair() throws NoSuchAlgorithmException {
        List<Integer> numbers = Lists.newArrayList(0, 10, 20, 30);
        Collections.sort(numbers);

        KeyPair keyPair = Security.generateKeyPair();
        assertThat(keyPair.getPrivate()).isNotNull();
        assertThat(keyPair.getPublic()).isNotNull();
    }

    @Test
    public void encryptAndDecrypt() throws NoSuchAlgorithmException {
        String plainText = "{}";
        KeyPair keyPair = Security.generateKeyPair();

        byte[] encodedPublicKey = keyPair.getPublic().getEncoded();
        byte[] encodedPrivateKey = keyPair.getPrivate().getEncoded();

        String cipherText = Security.encrypt(plainText, encodedPublicKey);
        assertThat(plainText).isEqualTo(Security.decrypt(cipherText, encodedPrivateKey));
    }

    @Test
    public void signAndVerify() throws NoSuchAlgorithmException {
        String plainText = "{}";
        KeyPair keyPair = Security.generateKeyPair();

        byte[] encodedPrivateKey = keyPair.getPrivate().getEncoded();
        byte[] encodedPublicKey = keyPair.getPublic().getEncoded();

        String signature = Security.sign(plainText, encodedPrivateKey);
        System.out.println("signature = " + signature);
        assertThat(signature).isNotNull();

        boolean result = Security.verify(plainText, signature, encodedPublicKey);
        assertThat(result).isTrue();
    }

    @Test(expected = InvalidSignatureException.class)
    public void signAndVerifyButGoogleSecurityException() throws NoSuchAlgorithmException {
        String plainText = "{}";
        KeyPair keyPair = Security.generateKeyPair();
        KeyPair otherKeyPair = Security.generateKeyPair();

        byte[] encodedPrivateKey = keyPair.getPrivate().getEncoded();
        byte[] encodedPublicKey = otherKeyPair.getPublic().getEncoded();

        String signature = Security.sign(plainText, encodedPrivateKey);
        assertThat(signature).isNotNull();

        Security.verify(plainText, signature, encodedPublicKey);
    }
}
