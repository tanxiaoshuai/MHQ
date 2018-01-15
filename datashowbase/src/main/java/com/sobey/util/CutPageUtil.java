package com.sobey.util;

import com.sobey.entity.CutPage;

import java.util.List;

/**
 * Created by 61682 on 2017/5/11.
 */
public class CutPageUtil {

    public static CutPage getCutPage(List list, Long count, Integer pageSize){
        CutPage cutPage = BeanFactoryUtil.getBeanByClass(CutPage.class);
        cutPage.setList(list);
        if(count % pageSize == 0){
            cutPage.setTotalpage(count / pageSize);
        }
        if(count % pageSize != 0){
            cutPage.setTotalpage(count / pageSize + 1);
        }
        cutPage.setCount(count);
        return cutPage;
    }
}
