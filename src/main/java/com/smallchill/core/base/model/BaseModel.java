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
package com.smallchill.core.base.model;

import com.smallchill.core.shiro.ShiroKit;
import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class BaseModel implements Serializable {

    private Integer version; //版本号

    private Integer id; //编号
    private Date created;   // 创建时间
    private Date updated;   // 更新时间
    private Integer updatedBy;  // 更新人
    private Integer createdBy;  // 创建人
    private Integer sRoleId;    // 安全性角色
    private Integer sDeptId;    // 安全性部门

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreated() {
        return created;
    }


    public void setCreated(Date created) {
        if (created != null)
            this.created = created;
        else
            this.created = new Date();
    }

    public Date getUpdated() {
        if (this.updated == null)
            return new Date();
        else
            return updated;
    }

    public void setUpdated(Date updated) {

        if (updated != null)
            this.updated = updated;
        else
            this.updated = new Date();
    }

    public Integer getUpdatedBy() {
        if (this.updatedBy == null)
            return (Integer) ShiroKit.getUser().getId();
        else
            return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {

        if (updatedBy == null)
            this.updatedBy = (Integer) ShiroKit.getUser().getId();
        else
            this.updatedBy = updatedBy;
    }

    public Integer getCreatedBy() {
        if (this.createdBy == null)
            return (Integer) ShiroKit.getUser().getId();
        else
            return createdBy;
    }


    public void setCreatedBy(Integer createdBy) {
        if (createdBy == null)
            this.createdBy = (Integer) ShiroKit.getUser().getId();
        else
            this.createdBy = createdBy;
    }

    public Integer getsRoleId() {
        return sRoleId;
    }


    public void setsRoleId(Integer sRoleId) {
        if (sRoleId == null)
            this.sRoleId = ShiroKit.getUser().getCurrentRoleId();
        else
            this.sRoleId = sRoleId;
    }

    public Integer getsDeptId() {
        if (sDeptId == null)
            return (Integer) ShiroKit.getUser().getDeptId();
        else
            return sDeptId;
    }


    public void setsDeptId(Integer sDeptId) {
        if (sDeptId == null)
            this.sDeptId = (Integer) ShiroKit.getUser().getDeptId();
        else
            this.sDeptId = sDeptId;
    }

}
