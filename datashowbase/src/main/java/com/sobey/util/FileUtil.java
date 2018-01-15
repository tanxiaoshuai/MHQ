package com.sobey.util;

import com.alibaba.fastjson.JSONObject;
import com.sobey.exception.FinalException;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Scanner;

/**
 * Created by TS on 2017/9/4.
 */
public class FileUtil {

    /**
     * 获取所有文件信息
     * @return
     */
    public static Object getDataFile(Resource res){
        try {
            File file = res.getFile();
            String jsonData = readfile(file);
            JSONObject object = JSONObject.parseObject(jsonData);
            return object;
        } catch (Exception e) {
            throw new FinalException("02","未找到json配置文件的地址");
        }
    }


    /**
     *  读取文件类容为字符串
     * @param file
     * @return
     */
    public static String readfile(File file){
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception e) {
            throw new FinalException("02","读取json配置文件失败");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        String fileJson = buffer.toString();
        if(StringUtils.isEmpty(fileJson)){
            throw new FinalException("02" , "读取配置文件类容为空");
        }
        return fileJson;
    }
}
