package com.hysy.data_collection.backstage.util;

/**
 * 16进制转10进制
 * @author czy
 * @version 2019-03-12
 */
public class ConverterUtil {
    /**
     * 16转10
     */
    public static String converter(String converter) {
        return String.valueOf(Long.parseLong(converter, 16));
    }

    /**
     * int类型转16进制字符串 4字节
     *
     * @param num
     * @return
     */
    public static String numtohex32(int num) {
        return String.format("%08x", num);
    }


    /**
     * Desc: num 要转换的数 from源数的进制 to要转换成的进制
     *
     * @param num
     * @param from
     * @param to
     * @return
     * @author Administrator
     */
    public static String base_convert(String num, int from, int to) {
        return new java.math.BigInteger(num, from).toString(to);
    }



    /**
     * 字符串自动补位
     *
     * @param str
     *            原字符串

     * @param flg
     *            0：左侧补位，1：右侧补位
     * @return
     */
    public static String str_pad(String str, String padChar, Integer length, int flg) {

        while (str.length() < length) {
            if (0 == flg) {
                str = padChar + str;
            } else {
                str = str + padChar;
            }

        }
        return str;
    }
}
