package com.business.recommend.util;

import com.alibaba.fastjson.serializer.NameFilter;
import org.beetl.sql.core.kit.StringKit;

/**
 * Created by ysisl on 17/8/7.
 */
public class UnderlineConvertNameFilter implements NameFilter {
    @Override
    public String process(Object o, String s, Object o1) {
        if (!s.toLowerCase().equals(s))
            return StringKit.enCodeUnderlined(s);
        else if (s.equals("md5"))
            return "MD5";
        return s;
    }
}
