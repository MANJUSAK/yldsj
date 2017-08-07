package com.goodsoft.yuanlin.util;

import javax.servlet.http.HttpServletRequest;

/**
 * function 获取服务器域名工具类
 * <p>
 * date 2017.08.04
 *
 * @author 严彬荣
 */
public class DomainNameUtil {

    /**
     * 创建本类的单例模式（具体说明参见本包下的UUIDUtil类）
     */
    private volatile static DomainNameUtil instance;

    private DomainNameUtil() {
    }

    public static DomainNameUtil getInstance() {
        if (instance == null) {
            synchronized (DomainNameUtil.class) {
                if (instance == null)
                    instance = new DomainNameUtil();
            }
        }
        return instance;
    }

    public StringBuilder getServerDomainName(HttpServletRequest request) {
        StringBuilder str = null;
        //判断服务器端口是否为80端开口
        if (request.getServerPort() == 80) {
            str = new StringBuilder(request.getScheme());
            str.append("://");
            str.append(request.getServerName());
        } else {
            str = new StringBuilder(request.getScheme());
            str.append("://");
            str.append(request.getServerName());
            str.append(":");
            str.append(request.getServerPort());
        }
        return str;
    }
}
