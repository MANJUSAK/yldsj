package com.goodsoft.yuanlin.test;

import com.horizon.util.encrypt.DESEDE;

public class test {
    public static void main(String[] args) {
        String name = "abcdef";
        String pwd = "abcfhsdhshdh1234";
        System.out.println(DESEDE.decryptIt("ED94C2C049B041FD"));//解密
        System.out.println(DESEDE.encryptIt(pwd));//加密
        System.out.println(DESEDE.decryptIt(DESEDE.encryptIt(pwd)));
    }

}
