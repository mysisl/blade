/**
 * @Description:TODO
 * @author:HuangLJ
 * @time:2017年8月3日 下午1:56:45
 */
package com.business.recommend.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.smallchill.core.base.model.BaseModel;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @author HuangLJ
 * @Description 发送请求获取推荐信息
 */
@Table(name = "rec_request")
@SuppressWarnings("serial")
public class SuggestRequest extends BaseModel {

    private String md5; // md5(bid&request_id&TOKEN)
    private String service_type; // 服务类型。0：pCTR，1：流量优选，2：pCVR，3：个性化推荐（默认），4：物料优选
    private String requestId; // request_id 为“毫秒级时间戳随机数”
    private String bid; // 腾讯云为该业务分配的业务标识
    private String uidType; // 0：QQ，1：微信号，3：设备号imei/idfa或其md5值（默认），4：手机号
    private String uid; // QQ，微信号，imei/idfa或其md5值，手机号
    private String sceneId; // 广告展示场景,请求服务时scene_id与上报数据时保持一致
    private String requestNum; // 物料优选个数。默认每次请求50个
    private String poolId; // 物料池，多个池子用 ; 号隔开
    private String cid; // 当前物料（用于详情页推荐中指定当前物料）
    private Double latitude;
    private Double longitude;
    private String country;
    private String city;
    private String syncCode;
    private String syncMsg;


    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getUidType() {
        return uidType;
    }

    public void setUidType(String uidType) {
        this.uidType = uidType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(String requestNum) {
        this.requestNum = requestNum;
    }

    public String getPoolId() {
        return poolId;
    }

    public void setPoolId(String poolId) {
        this.poolId = poolId;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSyncCode() {
        return syncCode;
    }

    public void setSyncCode(String syncCode) {
        this.syncCode = syncCode;
    }

    public String getSyncMsg() {
        return syncMsg;
    }

    public void setSyncMsg(String syncMsg) {
        this.syncMsg = syncMsg;
    }
}
