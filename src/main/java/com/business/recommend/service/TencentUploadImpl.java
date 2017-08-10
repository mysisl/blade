package com.business.recommend.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.business.recommend.model.Action;
import com.business.recommend.model.Item;
import com.business.recommend.model.ResponseItem;
import com.business.recommend.model.SuggestRequest;
import com.business.recommend.util.HttpRequestUtil;
import com.business.recommend.util.JsonUtil;
import com.smallchill.core.annotation.DoLog;
import com.smallchill.core.constant.ConstConfig;
import com.smallchill.core.plugins.dao.Blade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ysisl on 17/8/6.
 */

@Service
public class TencentUploadImpl implements TecentUpload {

    @Override
    public Item itemUpload(Item item) {
        String url = ConstConfig.ITEM_UPLOAD_URL;
        String itemJson = JsonUtil.ObjToJson(item);
        //String itemtest = "{\"md5\":\"testMd5\",\"bid\":\"b_teg_openrecom_ujwu65iquql72ugizntl\",\"big_type\":\"家具\",\"data_type\":\"1\",\"describe\":\"欧式简约储物柜\",\"free\":\"0\",\"geo\":{\"city\":\"广州\",\"country\":\"China\",\"latitude\":35.23,\"longitude\":130.123},\"item_id\":\"W-97I8V\",\"item_time\":\"1501644978\",\"middle_type\":\"柜子\",\"platform\":\"3\",\"pool_id\":\"poolId1\",\"price\":0.0,\"publish\":\"1\",\"request_id\":\""+String.valueOf(System.currentTimeMillis())+"\",\"score\":8.1,\"small_type\":\"储物柜\",\"tags\":\"家具;储物柜;欧式风格;简约;怀旧\",\"url\":null,\"vender\":\"店铺\"}";
        //String itemtest = "{\"MD5\":\"testMd5\",\"bid\":\"b_teg_openrecom_ujwu65iquql72ugizntl\",\"big_type\":\"家具\",\"data_type\":\"1\",\"describe\":\"双开门式衣柜\",\"free\":\"0\",\"geo\":{\"city\":\"广州\",\"country\":\"China\",\"latitude\":35.23,\"longitude\":130.123},\"item_id\":\"W-97I8J\",\"item_time\":\"1501644978\",\"middle_type\":\"双开柜\",\"platform\":\"3\",\"pool_id\":\"poolId1\",\"price\":0.0,\"publish\":\"1\",\"request_id\":\""+String.valueOf(System.currentTimeMillis())+"\",\"score\":7.9,\"small_type\":\"储物柜\",\"tags\":\"家具;双开衣柜;欧式风格;简约;怀旧\",\"url\":null,\"vender\":\"店铺\"}";
        //String itemtest = "{\"MD5\":\"testMd5\",\"bid\":\"b_teg_openrecom_ujwu65iquql72ugizntl\",\"big_type\":\"家具\",\"data_type\":\"1\",\"describe\":\"藤制桌椅\",\"free\":\"0\",\"geo\":{\"city\":\"广州\",\"country\":\"China\",\"latitude\":35.23,\"longitude\":130.123},\"item_id\":\"W-97CW4\",\"item_time\":\"1501644978\",\"middle_type\":\"桌椅\",\"platform\":\"3\",\"pool_id\":\"poolId1\",\"price\":0.0,\"publish\":\"1\",\"request_id\":\"1501644979261\",\"score\":4.5,\"small_type\":\"椅子\",\"tags\":\"家具;藤制品;古家具;简约;古董\",\"url\":null,\"vender\":\"店铺\"}";
        //String itemtest = "{\"MD5\":\"testMd5\",\"bid\":\"b_teg_openrecom_ujwu65iquql72ugizntl\",\"big_type\":\"家具\",\"data_type\":\"1\",\"describe\":\"实木餐桌\",\"free\":\"0\",\"geo\":{\"city\":\"广州\",\"country\":\"China\",\"latitude\":35.23,\"longitude\":130.123},\"item_id\":\"W-978DD\",\"item_time\":\"1501644978\",\"middle_type\":\"桌子\",\"platform\":\"3\",\"pool_id\":\"poolId1\",\"price\":0.0,\"publish\":\"1\",\"request_id\":\""+String.valueOf(System.currentTimeMillis())+"\",\"score\":8.1,\"small_type\":\"餐桌\",\"tags\":\"家具;桌子;古典;简约;怀旧\",\"url\":null,\"vender\":\"店铺\"}";
        System.out.println("itemJson：" + itemJson);
        String result = HttpRequestUtil.jsonPost(url, itemJson);
        JSONObject jsonObj = JSONObject.parseObject(result);
        String code = jsonObj.getString("code");
        String msg = jsonObj.getString("msg");
        item.setSyncCode(code);
        item.setSyncMsg(msg);
        Blade.create(Item.class).update(item);
        return item;
    }

    @Override
    public Action actionUpload(Action action) {
        String url = ConstConfig.ACTION_UPLOAD_URL;
        String actionJson = JsonUtil.ObjToJson(action);
        //String itemtest = "{\"MD5\":\"testMd5\",\"bid\":\"b_teg_openrecom_ujwu65iquql72ugizntl\",\"big_type\":\"家具\",\"data_type\":\"1\",\"describe\":\"欧式简约储物柜\",\"free\":\"0\",\"geo\":{\"city\":\"广州\",\"country\":\"China\",\"latitude\":35.23,\"longitude\":130.123},\"item_id\":\"W-97I8V\",\"item_time\":\"1501644978\",\"middle_type\":\"柜子\",\"platform\":\"3\",\"pool_id\":\"poolId1\",\"price\":0.0,\"publish\":\"1\",\"request_id\":\""+String.valueOf(System.currentTimeMillis())+"\",\"score\":8.1,\"small_type\":\"储物柜\",\"tags\":\"家具;储物柜;欧式风格;简约;怀旧\",\"url\":null,\"vender\":\"店铺\"}";
        //String itemtest = "{\"MD5\":\"testMd5\",\"bid\":\"b_teg_openrecom_ujwu65iquql72ugizntl\",\"big_type\":\"家具\",\"data_type\":\"1\",\"describe\":\"双开门式衣柜\",\"free\":\"0\",\"geo\":{\"city\":\"广州\",\"country\":\"China\",\"latitude\":35.23,\"longitude\":130.123},\"item_id\":\"W-97I8J\",\"item_time\":\"1501644978\",\"middle_type\":\"双开柜\",\"platform\":\"3\",\"pool_id\":\"poolId1\",\"price\":0.0,\"publish\":\"1\",\"request_id\":\""+String.valueOf(System.currentTimeMillis())+"\",\"score\":7.9,\"small_type\":\"储物柜\",\"tags\":\"家具;双开衣柜;欧式风格;简约;怀旧\",\"url\":null,\"vender\":\"店铺\"}";
        //String itemtest = "{\"MD5\":\"testMd5\",\"bid\":\"b_teg_openrecom_ujwu65iquql72ugizntl\",\"big_type\":\"家具\",\"data_type\":\"1\",\"describe\":\"藤制桌椅\",\"free\":\"0\",\"geo\":{\"city\":\"广州\",\"country\":\"China\",\"latitude\":35.23,\"longitude\":130.123},\"item_id\":\"W-97CW4\",\"item_time\":\"1501644978\",\"middle_type\":\"桌椅\",\"platform\":\"3\",\"pool_id\":\"poolId1\",\"price\":0.0,\"publish\":\"1\",\"request_id\":\"1501644979261\",\"score\":4.5,\"small_type\":\"椅子\",\"tags\":\"家具;藤制品;古家具;简约;古董\",\"url\":null,\"vender\":\"店铺\"}";
        //String itemtest = "{\"MD5\":\"testMd5\",\"bid\":\"b_teg_openrecom_ujwu65iquql72ugizntl\",\"big_type\":\"家具\",\"data_type\":\"1\",\"describe\":\"实木餐桌\",\"free\":\"0\",\"geo\":{\"city\":\"广州\",\"country\":\"China\",\"latitude\":35.23,\"longitude\":130.123},\"item_id\":\"W-978DD\",\"item_time\":\"1501644978\",\"middle_type\":\"桌子\",\"platform\":\"3\",\"pool_id\":\"poolId1\",\"price\":0.0,\"publish\":\"1\",\"request_id\":\""+String.valueOf(System.currentTimeMillis())+"\",\"score\":8.1,\"small_type\":\"餐桌\",\"tags\":\"家具;桌子;古典;简约;怀旧\",\"url\":null,\"vender\":\"店铺\"}";
        System.out.println("itemJson：" + actionJson);
        String result = HttpRequestUtil.jsonPost(url, actionJson);
        JSONObject jsonObj = JSONObject.parseObject(result);
        String code = jsonObj.getString("code");
        String msg = jsonObj.getString("msg");
        action.setSyncCode(code);
        action.setSyncMsg(msg);
        Blade.create(Action.class).update(action);
        return action;
    }

    @Override
    public SuggestRequest srGet(SuggestRequest suggestRequest) {
        String url = ConstConfig.SR_GET_URL;
        String srJson = JsonUtil.ObjToJson(suggestRequest);
        System.out.println("itemJson：" + srJson);
        String result = HttpRequestUtil.jsonPost(url, srJson);
        JSONObject jsonObj = JSONObject.parseObject(result);
        String code = jsonObj.getString("code");
        String msg = jsonObj.getString("msg");
        suggestRequest.setSyncCode(code);
        suggestRequest.setSyncMsg(msg);
        Blade.create(SuggestRequest.class).update(suggestRequest);

        if (!code.equals("0"))
            return suggestRequest;

        //获取返回的行参数
        JSONArray weightArray = jsonObj.getJSONArray("data");
        for (int i = 0; i < weightArray.size(); ++i) {
            JSONObject jObj = weightArray.getJSONObject(i);
            String itemId = jObj.getString("item");
            String weight = jObj.getString("weight");
            ResponseItem line = new ResponseItem();
            line.setRequestId(suggestRequest.getRequestId());
            line.setItemId(itemId);
            line.setWeight(weight);
            Blade.create(ResponseItem.class).save(line);

            System.out.println("产品：" + line + "\t 权值为：" + weight);
        }

        return suggestRequest;

    }
}
