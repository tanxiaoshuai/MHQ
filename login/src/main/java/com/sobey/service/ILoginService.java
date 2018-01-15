package com.sobey.service;

/**
 * Created by TS on 2017/7/28.
 */
public interface ILoginService {


    /**
     * 获取hivetoken
     * @param loginName
     * @param loginPassWord
     * @return
     * @throws Exception
     */
    public Object hive_token(String loginName, String loginPassWord) throws Exception;

    /**
     * 华西云获取token接口（get 请求只需登录名 配置在url里）
     * @return
     */
    public Object hxy_token() throws Exception;

}
