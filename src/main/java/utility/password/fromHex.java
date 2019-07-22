package utility.password;

import java.security.NoSuchAlgorithmException;

public class fromHex {
    static byte[] fromHex(String hex) throws NoSuchAlgorithmException {

        byte[] bytes = new byte[hex.length() / 2];

        for(int i = 0; i<bytes.length; i++) {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}