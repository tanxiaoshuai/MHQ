package com.sobey.service;

public interface IproducttivityService {

    /**
     * 微信 微博
      * @param type 1微博 2 微信
     * @return
     * @throws Exception
     */
    public Object publish(String type) throws Exception;

    /**
     * 最新发布微信 微博
     * @param type 1微博 2 微信
     * @return
     * @throws Exception
     */
    public Object newest(String type) throws Exception;

    /**
     * 写稿
     * @param body
     * @return
     * @throws Exception
     */
    public Object queryBySQL(String body) throws Exception;
}
