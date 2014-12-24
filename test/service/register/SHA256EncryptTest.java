package service.register;

import junit.framework.TestCase;

public class SHA256EncryptTest extends TestCase {
	public void testEncrypt() throws Exception {
		String value = "passward";
		String encryptedValue = SHA256Encrypt.encrypt(value);
		//System.out.println(encryptedValue);
		assertFalse(value.equals(encryptedValue));
	}
}
