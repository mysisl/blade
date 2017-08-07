/**
 * @Description:TODO
 * @author:HuangLJ
 * @time:2017年8月2日 上午10:35:30
 */
package com.business.recommend.service;


import com.business.recommend.model.Action;
import com.business.recommend.model.Item;
import com.business.recommend.model.SuggestRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author HuangLJ
 */
public interface TecentUpload {

    public Item itemUpload(Item item);

    public Action actionUpload(Action action);

    public SuggestRequest srGet(SuggestRequest suggestRequest);
}
