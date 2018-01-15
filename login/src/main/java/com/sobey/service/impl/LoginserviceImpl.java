package com.sobey.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sobey.config.BaseInfo;
import com.sobey.config.ConfigUrl;
import com.sobey.exception.FinalException;
import com.sobey.hiveUtil.HiveUser;
import com.sobey.service.ILoginService;
import com.sobey.util.EnumInfo;
import com.sobey.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TS on 2017/9/8.
 */
@Service
public class LoginserviceImpl implements ILoginService {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginserviceImpl.class);

    @Autowired
    private BaseInfo info;

    @Autowired
    private ConfigUrl con;

    @Override
    public Object hive_token(String loginName, String loginPassWord) throws Exception {
        JSONObject body = new JSONObject();
        body.put("loginName" , loginName);
        body.put("password" , loginPassWord);
        Map map = new HashMap();
        map.put("sobeyhive-http-operate-site" , info.getSitecode());
        map.put("sobeyhive-http-site" , info.getSitecode());
        map.put("sobeyhive-http-system" , "SobeyHive");
        LOGGER.info("hive登陆地址：[" + con.getHive_login() +"]");
//        String result = HttpClientUtil.postHeader(body.toString() , con.getHive_login() , map);
        String hres = HiveUser.login(con.getHive_ip() , info.getHiveloginname() , info.getHivepassword() , info.getSitecode());
        JSONObject object = JSONObject.parseObject(hres);
        LOGGER.info("登陆成功token值为:["+ object.getString("userToken") +"]");
        if(StringUtils.isEmpty(object.getString("userToken"))){
            LOGGER.error("hive登陆失败。返回参数信息" + object);
            throw new FinalException(EnumInfo.HIVE_LOGIN_ERROR);
        }
        return object.getString("userToken");
    }

    @Override
    public Object hxy_token() throws Exception {
        String result = HttpClientUtil.getHeader(con.getHxy_login() , null);
        JSONObject obj = JSONObject.parseObject(result);
        Integer code = obj.getInteger("code");
        if(code != 0){
            LOGGER.error("华西云登陆失败。返回参数信息" + obj);
            throw new FinalException(EnumInfo.HXY_LOGIN_ERROR);
        }
        return obj.getString("msg");
    }
}
