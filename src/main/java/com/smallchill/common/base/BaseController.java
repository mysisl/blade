package com.smallchill.common.base;

import com.smallchill.core.base.controller.BladeController;
import com.smallchill.core.constant.ConstCache;
import com.smallchill.core.constant.ConstCacheKey;
import com.smallchill.core.constant.ConstCurd;
import com.smallchill.core.meta.IMeta;

/**
 * 用于拓展controller类
 */
public class BaseController extends BladeController implements ConstCurd, ConstCache, ConstCacheKey {


    /**
     * 数据安全性 权限
     **/
    public Integer VIEW_MODE = SEC_ALL; // 默认所有安全性



}
