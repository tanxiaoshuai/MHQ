package com.sobey.service;

import com.alibaba.fastjson.JSONObject;
import com.sobey.dao.WatchDao;
import com.sobey.model.WatchList;
import com.sobey.service.impl.IWatchDataService;
import com.sobey.util.DateUtil;
import com.sobey.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TS on 2017/10/18.
 */
@Service
public class WatchDataServiceImpl implements IWatchDataService {

    @Autowired
    private WatchDao watchDao;


    @Override
    public Object getWatchData() throws Exception {
        List<WatchList> list = watchDao.searchwatch();
        WatchList watchList = list != null && list.size() > 0 ? list.get(0) : null;
        return ReturnInfo.success(watchList);
    }

    @Override
    public Object updateWatchData(String body) throws Exception {
        WatchList object = JSONObject.parseObject(body , WatchList.class);
        object.setUpdatetime(DateUtil.longForDate(System.currentTimeMillis()));
        watchDao.updatewatch(object);
        return ReturnInfo.success();
    }
}
