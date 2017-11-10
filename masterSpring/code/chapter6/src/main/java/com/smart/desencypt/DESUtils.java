package com.smart.desencypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DESUtils {

    // 指定DES加密解密所有的密钥
    private static Key key;

    // 用于生成密钥的字符串
    private static String KEY_STR = "hahaha";

    /**
     * static块：在类被加载的时候会执行且仅被执行一次
     */
    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key = generator.generateKey();
            generator = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对字符串进行DES加密
     * @param str
     * @return
     */
    public static String getEncryptString(String str)
    {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            byte[] strBytes = str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return base64Encoder.encode(encryptStrBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对字符串进行DES解密
     * @param str
     * @return
     */
    public static String getDecryptString(String str)
    {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] strBytes = base64Decoder.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptStrBytes = cipher.doFinal(strBytes);
            return new String(decryptStrBytes, "UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        if (args == null || args.length < 1)
        {
            System.out.println("请输入加密的字符，用空格分割");

            // 接收从控制台输入的字符
            byte[] b = new byte[100];
            int n = System.in.read(b);
            String s = new String(b, 0, n);

            String encryptStr = getEncryptString(s);
            System.out.println("加密后的字符串：" + encryptStr);
            String decryptStr = getDecryptString(encryptStr);
            System.out.println("解密后的字符串：" + decryptStr);

        }
    }

}
