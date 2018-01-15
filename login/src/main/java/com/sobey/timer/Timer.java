package com.sobey.timer;
import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling // 启用定时任务
public class Timer {

    private static Logger LOGGER = LoggerFactory.getLogger(Timer.class);

    private static String  HX_TOKEN = null;

    @Autowired
    private BaseInfo baseInfo;

    @Autowired
    private ILoginService loginService;


    @Scheduled(fixedRate = 1000*60*58*2)
    public void scheduler() throws Exception {

        if(!baseInfo.isSwitchmhq()) {
            LOGGER.info("免登陆初始化配置成功：" + JSONObject.toJSONString(baseInfo , true));
            return;
        }
        String hiveToken = (String) loginService.hive_token(baseInfo.getHiveloginname() , baseInfo.getHivepassword());//获取hive token
        LOGGER.info("初始化获取hive token: " + hiveToken);
        String hxyToken = (String) loginService.hxy_token();
        LOGGER.info("初始化华西云 token：" + hxyToken);
        baseInfo.setHivetoken(hiveToken);
        baseInfo.setHxytoken(hxyToken);
    }
}
