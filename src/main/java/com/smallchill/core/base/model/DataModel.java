/**
 * Copyright (c) 2015-2017, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smallchill.core.base.model;

import com.smallchill.core.plugins.dao.Blade;
import com.smallchill.core.shiro.ShiroKit;
import com.smallchill.core.toolbox.cache.CacheKit;
import com.smallchill.core.toolbox.cache.ILoader;
import com.smallchill.system.model.Role;
import org.beetl.sql.core.annotatoin.UpdateIgnore;
import org.beetl.sql.core.annotatoin.Version;

import java.io.Serializable;
import java.util.Date;

import static com.smallchill.core.constant.ConstCache.SYS_CACHE;
import static com.smallchill.core.constant.ConstCacheKey.GET_ROLE_NAME;

/**
 * 包含业务对象基本数据属性的通用实体类
 * 包括 创建信息，更新信息
 * 包括 数据安全性信息
 */
@SuppressWarnings("serial")
public class DataModel extends BaseModel implements Serializable {


}