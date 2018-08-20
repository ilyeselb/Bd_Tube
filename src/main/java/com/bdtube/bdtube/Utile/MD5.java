package com.bdtube.bdtube.Utile;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static void main(String[] args)
            throws IOException, NoSuchAlgorithmException {

        InputStream in = new FileInputStream(args[0]);

        try {
            System.out.println(md5(in));
        } finally {
            in.close();
        }

        System.out.println("HOGE".getBytes("UTF-8"));
    }

    public static String md5(InputStream in)
            throws IOException, NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("MD5");

        byte[] buf = new byte[1024];

        int i = 0;
        while ((i = in.read(buf)) > -1) {
            digest.update(buf, 0, i);
        }

        StringBuilder md5 = new StringBuilder();
        for (byte b : digest.digest()) {
            if ((0xff & b) < 0x10) { md5.append("0"); }
            md5.append(Integer.toHexString(0xff & b));
        }

        return md5.toString();
    }

    public static String md5(byte[] b)
            throws IOException, NoSuchAlgorithmException {
        return md5(new ByteArrayInputStream(b));
    }
}
