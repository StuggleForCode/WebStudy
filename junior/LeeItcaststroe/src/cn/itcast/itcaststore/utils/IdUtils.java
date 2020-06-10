package cn.itcast.itcaststore.utils;

import java.util.UUID;

/**
 * 生成订单id工具类
 */
public class IdUtils {
    //获取uuid
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
