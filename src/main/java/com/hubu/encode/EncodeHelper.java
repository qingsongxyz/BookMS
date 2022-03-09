package com.hubu.encode;

import org.springframework.util.DigestUtils;

public class EncodeHelper {

    /**
     * 加密
     * 先将密码加上字符串“666”，再经过MD5加密
     * @param str
     * @return
     */
    public static String encode(String str){
        return DigestUtils.md5DigestAsHex((str + "666").getBytes());
    }
}
