package com.business.recommend.service;

import com.smallchill.core.aop.AopContext;
import com.smallchill.core.meta.MetaIntercept;
import com.smallchill.core.toolbox.support.Convert;

/**
 * Created by ysisl on 17/8/6.
 */
public class ResponseItemIntercept extends MetaIntercept {

    /**
     * 查询前操作
     *
     * @param ac
     */
    public void queryBefore(AopContext ac) {

        String reqeustId = ac.getCtrl().getParameter("requestId");
        String condition = "and request_id = '#{requestId}' ";
        ac.setCondition(condition);
        ac.getParam().put("requestId", reqeustId);
    }

}
