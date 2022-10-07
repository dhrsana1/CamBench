package main.java.org.cambench.cap.mixedsensitivities.flowpath.truenegative.smallkeysize;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class SmallKeySize2 {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA");
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        int condition =1;

        if(condition > 2){
            keyGen.initialize(1024);
        } else {
            keyGen.initialize(2048);
        }

        KeyPair keyPair = keyGen.generateKeyPair();
        cipher.init(Cipher.ENCRYPT_MODE,keyPair.getPublic());
    }
}