package com.imooc.utils;

import java.util.UUID;

/**
 * UUID 服务类
 */
public class UUIDUtils {

    /**
     * 产生UUID去除“-”
     * @return
     */
    public static String createUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-","");
    }
}
