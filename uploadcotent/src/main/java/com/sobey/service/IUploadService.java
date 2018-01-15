package com.sobey.service;

/**
 * Created by TS on 2017/8/30.
 */
public interface IUploadService {

    /**
     * 资源上传（pgc , vtube , localupload）
     * @param body
     * @return
     */
    public Object resource_upload(String body) throws Exception;

    /**
     * pgc上传后回掉函数
     * @param body
     * @return
     * @throws Exception
     */
    public Object call_back(String body) throws Exception;
}
