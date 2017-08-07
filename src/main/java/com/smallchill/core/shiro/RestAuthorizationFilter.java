/**
 * Copyright (c) 2015-2017, Chill Zhuang 庄骞 (smallchill@163.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smallchill.core.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.smallchill.core.toolbox.ajax.AjaxResult;
import com.smallchill.core.toolbox.kit.HashKit;
import com.smallchill.core.toolbox.kit.HttpKit;
import com.smallchill.core.toolbox.kit.StrKit;
import com.smallchill.core.toolbox.support.Convert;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RestAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest arg0, ServletResponse arg1, Object arg2) throws Exception {
		// rest为无状态,shiro自带过滤器无法校验,所以写个空过滤器放行
		HttpServletRequest request = (HttpServletRequest) arg0;

		Map<String, Object> headMap = new HashMap<String, Object>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = headerNames.nextElement();
			String value = request.getHeader(key);
			headMap.put(key, value);
		}
		String nonce = Convert.toStr(request.getParameter("nonce"), "");
		String timestamp = Convert.toStr(request.getParameter("timestamp"), "");
		String signature = Convert.toStr(request.getParameter("signature"), "");
		String _signature = HashKit.md5(nonce + timestamp);
		if (!StrKit.equals(_signature, signature)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		AjaxResult result = new AjaxResult();
		result.addError("您提交的签名有误,无法访问该资源!");
		response.getWriter().append(result.toString());

		return false;

	}
}
