package com.business.recommend.controller;

import com.business.recommend.model.SuggestRequest;
import com.smallchill.core.annotation.Json;
import com.smallchill.core.annotation.JsonToken;
import com.smallchill.core.base.controller.BladeController;
import com.smallchill.core.toolbox.ajax.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ysisl on 17/8/8.
 */
@RestController
@RequestMapping("/rest")
public class WechatControlller extends BladeController {

    @RequestMapping("/test")
    public AjaxResult test() {

        return success("微信接口测试成功");
    }
}
