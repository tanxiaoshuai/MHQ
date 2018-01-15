package com.sobey.util;

import com.alibaba.fastjson.JSONObject;
import com.sobey.dao.GisUserDao;
import com.sobey.model.GisUesr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;
@Configuration
@EnableScheduling
public class HeartBeat {

    private Logger LOGGER = LoggerFactory.getLogger(HeartBeat.class);

    @Autowired
    private GisUserDao gisUserDao;

    @Scheduled(fixedRate = 1000*60*1)
    public void scheduler() throws Exception {
        long time = System.currentTimeMillis() - 1000L * 60L * 3L;
        List<GisUesr> uesrs = gisUserDao.search_heart(Dates.getDate(time));
        LOGGER.info("心跳包获取数据["+Dates.getDate(time )+"]：" +JSONObject.toJSON(uesrs));
        if(uesrs != null && uesrs.size() > 0){
            for(GisUesr u : uesrs){
                u.setLstatus("2");
                gisUserDao.update(u);
            }
        }
    }
}
