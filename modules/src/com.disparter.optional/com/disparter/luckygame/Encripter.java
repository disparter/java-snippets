package com.disparter.luckygame;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public final class Encripter {
	
    public static final int AES_KEY_BITS_SIZE = 128; 
    public static final int GCM_NONCE_BITS_LENGTH = 12; 
    public static final int GCM_TAG_BITS_LENGTH = 16; 	
    public static final String AES = "AES";
    
	public final static String encript(String value, String aad) throws EncriptionException {
        byte[] input = value.getBytes();

        try {
	        SecureRandom random = SecureRandom.getInstanceStrong();
	        KeyGenerator keyGen = KeyGenerator.getInstance(AES);
	        keyGen.init(AES_KEY_BITS_SIZE, random);
	        SecretKey key = keyGen.generateKey();
	
	        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "SunJCE");
	        final byte[] nonce = new byte[GCM_NONCE_BITS_LENGTH];
	        random.nextBytes(nonce);
	        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_BITS_LENGTH * 8, nonce);
	        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
	        byte[] aadBytes = aad.getBytes();
	        cipher.updateAAD(aadBytes);
	        byte[] cipherText = cipher.doFinal(input);
	        return new String(cipherText);
        }catch (Exception e) {
        	throw new EncriptionException(e);
        }

	}
}
