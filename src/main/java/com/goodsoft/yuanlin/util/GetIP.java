package com.goodsoft.yuanlin.util;

import javax.servlet.http.HttpServletRequest;

/**
 * function 获取用户ip工具类
 * Created by 严彬荣 on 2017/8/14.
 */
public class GetIP {
    /**
     * 创建本类的单例模式（具体说明参见本包下的UUIDUtil类） start
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
    // 创建本类的单例模式（具体说明参见本包下的UUIDUtil类） end


    /**
     * @param request http请求
     * @return 访问服务器客户端ip
     */
    public String getIP(HttpServletRequest request) {
        //获取用户ip地址 start
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
        //获取用户ip地址 start
        return ip;
    }
}
