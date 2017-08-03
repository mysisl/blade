package com.smallchill.system.meta.intercept;

import com.smallchill.core.aop.AopContext;
import com.smallchill.core.constant.ConstShiro;
import com.smallchill.core.meta.PageIntercept;
import com.smallchill.core.shiro.ShiroKit;
import com.smallchill.core.toolbox.support.Convert;

public class SecurityIntercept extends PageIntercept {

    public void queryBefore(AopContext ac) {

        String roles = ShiroKit.getUser().getRoles() + "," + ShiroKit.getUser().getSubRoles();
        String condition = "and s_role_id in (#{join(ids)})";
        ac.setCondition(condition);
        ac.getParam().put("ids", Convert.toIntArray(roles));

    }

}
