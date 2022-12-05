package com.jr.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private static MD5Util mInstance = null;

    public static MD5Util getInstance() {

        if (mInstance == null) {

            mInstance = new MD5Util();
        }

        return mInstance;

    }

    /**

     * 获取字符串16进制hash值

     * @param input

     * @return

     */

    public String toHashHexStr(String input) {

        if (input == null || input.equals("")) {

            return null;
        }

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

// 输入的字符串转换成字节数组

            byte[] inputByteArray = input.getBytes();

// inputByteArray是输入字符串转换得到的字节数组

            messageDigest.update(inputByteArray);

// 转换并返回结果，也是字节数组，包含16个元素

            byte[] resultByteArray = messageDigest.digest();

// 字符数组转换成字符串返回

            return byteArrayToHex(resultByteArray);

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

            return null;

        }

    }

    private String byteArrayToHex(byte[] resultByteArray) {

        String hs = "";

        String stmp = "";

        for (int n = 0; n < resultByteArray.length; n++) {

            stmp = (Integer.toHexString(resultByteArray[n] & 0XFF));

            if (stmp.length() == 1)

                hs = hs + "0" + stmp;

            else

                hs = hs + stmp;

        }

        return hs.toUpperCase();

    }



}
