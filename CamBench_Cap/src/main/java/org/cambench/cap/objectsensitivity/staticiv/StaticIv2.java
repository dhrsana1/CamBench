package main.java.org.cambench.cap.objectsensitivity.staticiv;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class StaticIv2 {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();

        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);

        IvClass2 ivObject1 = new IvClass2(new byte[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'});
        IvClass2 ivObject2 = new IvClass2(randomBytes);
        IvParameterSpec iv = new IvParameterSpec(ivObject1.ivBytes);

        cipher.init(Cipher.ENCRYPT_MODE, keyGen.generateKey(), iv);
    }
}

class IvClass2 {
    byte[] ivBytes;

    public IvClass2(byte[] bytes){
        ivBytes = bytes;
    }
}
