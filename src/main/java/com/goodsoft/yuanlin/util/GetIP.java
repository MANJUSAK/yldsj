package com.goodsoft.yuanlin.util;

import javax.servlet.http.HttpServletRequest;

/**
 * function 获取用户ip工具类
 * Created by 严彬荣 on 2017/8/14.
 */
public class GetIP {
    /**
     * 创建本类的单例模式（具体说明参见本包下的UUIDUtil类）
     */
    private volatile static GetIP instance;

    private GetIP() {
    }

    public static GetIP getInstance() {
        if (instance == null) {
            synchronized (GetIP.class) {
                if (instance == null)
                    instance = new GetIP();
            }
        }
        return instance;
    }

    public String getIP(HttpServletRequest request) {
        //获取用户ip地址
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
