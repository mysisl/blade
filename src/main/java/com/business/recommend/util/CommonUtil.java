/**
 * @Description:TODO
 * @author:HuangLJ
 * @time:2017年8月2日 下午3:53:31
 */
package com.business.recommend.util;

/**
 * @author HuangLJ
 * @Description 获取10位时间戳
 */
public class CommonUtil {
    public static String get10DateStr() {
        String str = String.valueOf(System.currentTimeMillis());
        str = str.substring(0, str.length() - 3);
        return str;
    }
}
