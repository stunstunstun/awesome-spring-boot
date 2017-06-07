package com.stunstun.spring.support;

import org.junit.Test;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
public class GoogleSecurityTests {

    @Test
    public void generateKeyPair() throws NoSuchAlgorithmException {
        KeyPair keyPair = GoogleSecurity.generateKeyPair();
        assertThat(keyPair.getPrivate()).isNotNull();
        assertThat(keyPair.getPublic()).isNotNull();
    }

    @Test
    public void signAndVerify() throws NoSuchAlgorithmException {
        String plainText = "{}";
        KeyPair keyPair = GoogleSecurity.generateKeyPair();

        byte[] encodedPrivateKey = keyPair.getPrivate().getEncoded();
        byte[] encodedPublicKey = keyPair.getPublic().getEncoded();

        String signature = GoogleSecurity.sign(plainText, encodedPrivateKey);
        assertThat(signature).isNotNull();

        boolean result = GoogleSecurity.verify(plainText, signature, encodedPublicKey);
        assertThat(result).isTrue();
    }

    @Test(expected = GoogleSecurityException.class)
    public void signAndVerifyButGoogleSecurityException() throws NoSuchAlgorithmException {
        String plainText = "{}";
        KeyPair keyPair = GoogleSecurity.generateKeyPair();
        KeyPair otherKeyPair = GoogleSecurity.generateKeyPair();

        byte[] encodedPrivateKey = keyPair.getPrivate().getEncoded();
        byte[] encodedPublicKey = otherKeyPair.getPublic().getEncoded();

        String signature = GoogleSecurity.sign(plainText, encodedPrivateKey);
        assertThat(signature).isNotNull();

        GoogleSecurity.verify(plainText, signature, encodedPublicKey);
    }
}
