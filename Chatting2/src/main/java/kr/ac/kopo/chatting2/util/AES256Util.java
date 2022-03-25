package kr.ac.kopo.chatting2.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

@Component
public class AES256Util {
	private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
	private static byte[] KEY = "C*F)J@NcRfUjXn2r5u8x/A?D(G+KaPdS".getBytes();
	private static byte[] IV = "0000000000000000".getBytes();

	/**
	 * AES 양방향 암호화 하는 메소드
	 * @param plainText 평문 (원본 값)
	 * @return 암호화된 결과물 (base64 인코딩됨)
	 */
	public static String encrypt(String plainText) {
		if (plainText == null || plainText == "") {
			return plainText;
		}
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV));
			return new String(Base64.getEncoder().encode(cipher.doFinal(plainText.getBytes())));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * AES 양방향 암호화를 푸는 메소드
	 * @param encryptedText 암호화된 문자열
	 * @return 평문
	 */
	public static String decrypt(String encryptedText) {
		if (encryptedText == null || encryptedText == "") {
			return encryptedText;
		}
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV));
			return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
