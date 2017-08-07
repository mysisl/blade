/**
 * @Description:TODO
 * @author:HuangLJ
 * @time:2017年8月3日 下午1:39:24
 */
package com.business.recommend.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.beetl.sql.core.kit.StringKit;

import java.util.Collection;
import java.util.Set;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

/**
 * @author HuangLJ
 */
public class JsonUtil {
    public static String ObjToJson(Object obj) {

        NameFilter underlineFilter = new UnderlineConvertNameFilter();
        SimplePropertyPreFilter fieldfilter = new SimplePropertyPreFilter();
        Set<String> excFields = fieldfilter.getExcludes();
        excFields.add("id");
        excFields.add("created");
        excFields.add("createdBy");
        excFields.add("updated");
        excFields.add("updatedBy");
        excFields.add("version");
        excFields.add("sRoleId");
        excFields.add("sDeptId");

        // json序列化时设置下划线转换，字段过滤
        String jsonString = JSON.toJSONString(obj,
                new SerializeFilter[]{underlineFilter, fieldfilter});
        return jsonString;
    }
}
