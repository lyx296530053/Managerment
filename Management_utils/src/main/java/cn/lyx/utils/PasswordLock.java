package cn.lyx.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordLock {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("2038118");
        System.out.println(encode);
    }
}
