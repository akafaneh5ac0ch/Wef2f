package com.blade.kit;

import com.blade.mvc.http.Request;
import lombok.NoArgsConstructor;

/**
 * @author biezhi
 * 2017/6/2
 */
@NoArgsConstructor
public final class WebKit {

    private static final String UNKNOWN_MAGIC = "unknown";

    /**
     * 根据request对象获取客户端ip地址
     *
     * @param request
     * @return
     */
    public static String ipAddr(Request request) {
        String ipAddress = request.header("x-forwarded-for");
        if (StringKit.isBlank(ipAddress) || UNKNOWN_MAGIC.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.header("Proxy-Client-IP");
        }
        if (StringKit.isBlank(ipAddress) || UNKNOWN_MAGIC.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.header("WL-Proxy-Client-IP");
        }
        if (StringKit.isBlank(ipAddress) || UNKNOWN_MAGIC.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.header("X-Real-IP");
        }
        if (StringKit.isBlank(ipAddress)) {
            ipAddress = "127.0.0.1";
        }
        return ipAddress;
    }

}
