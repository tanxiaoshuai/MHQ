package com.sobey.util;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by TS on 2017/8/6.
 */
@Component
public class StartRun implements CommandLineRunner {

    public static JSONObject baseInfo = null;

    private final static Logger logger = LoggerFactory.getLogger(StartRun.class);

    @Value(value="classpath:/base.json")
    private Resource res;

    @Override
    public void run(String... strings) throws Exception {
        baseInfo = (JSONObject) FileUtil.getDataFile(res);
        logger.info("hive基础数据配置获取成功：" + JSONObject.toJSONString(baseInfo , true));
    }
}
