package javase.demo.md5;


import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MD5Test {
    private static String toHex(byte[] bytes) {
        final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    @Test
    public void testMD5() throws NoSuchAlgorithmException {
        //The result should be the same as the openssl command below
        // $ echo -n 1293874ysodfhasdfhhsdklfhaklhhdhfdfsd | openssl md5
        String data = "1293874ysodfhasdfhhsdklfhaklhhdhfdfsd";
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5 = md.digest(data.getBytes());
        String md5Str =  toHex(md5);
        System.out.println(Arrays.toString(md5));
        System.out.println(md5Str);
        assertEquals(md5Str, "a35f508e5a764104e941d0dd2963efa8");
    }

    @Test
    public void stringByteArrayConversion () {
        String testStr = "abcde12345";
        byte[] strByteArray = testStr.getBytes();
        System.out.println(Arrays.toString(strByteArray));

        String converBack = new String(strByteArray);
        System.out.println(converBack);
    }
}
