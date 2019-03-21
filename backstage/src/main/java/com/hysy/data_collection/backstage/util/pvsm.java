package com.hysy.data_collection.backstage.util;

/**
 * Created by Administrator on 2019/3/14.
 */
public class pvsm {
    public static void ss(){
        String a= "0100";
        char[] chars = a.toCharArray();
        String b="";
        for(int i = 0;i<chars.length;i++){
            b+=Integer.toBinaryString(chars[i])+" ";
        }
        System.out.println(b);
    }

}
