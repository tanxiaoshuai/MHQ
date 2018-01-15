package com.sobey.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {

    /**
     * 模板
     */
    public static String DATE_FORMAT_BZ = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取标准时间格式
     * @param time
     * @return
     */
    public static String getDate(long time){
        Date date = new Date(time);
        SimpleDateFormat mat = new SimpleDateFormat(DATE_FORMAT_BZ);
        return mat.format(date);
    }

}
