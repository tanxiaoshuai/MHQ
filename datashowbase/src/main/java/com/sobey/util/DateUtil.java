package com.sobey.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by TS on 2017/7/13.
 */
public class DateUtil {

    /**
     * 将时间毫秒转化为 yyyy-MM-dd HH:mm:ss格式
     * @param time
     * @return
     */
    public static String longForDate(long time){
        Date date = new Date(time);
        //标准日历系统类
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        //设置时间格式
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到毫秒值转化的时间
        String dateStr = format.format(gc.getTime());
        return dateStr;
    }

    /**
     * 将时间毫秒转化为 yyyy-MM-dd HH:mm:ss格式
     * @param time
     * @return
     */
    public static String longForDate(long time , String formatStr){
        Date date = new Date(time);
        //标准日历系统类
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        //设置时间格式
        SimpleDateFormat format =  new SimpleDateFormat(formatStr);
        //得到毫秒值转化的时间
        String dateStr = format.format(gc.getTime());
        return dateStr;
    }

    /**
     * 将时间模板   转化为毫秒"yyyy-MM-dd HH:mm:ss"
     * @param time
     * @return
     */
    public static long longForDate(String time , String formatStr){
        SimpleDateFormat format =  new SimpleDateFormat(formatStr);
        long dateL = 0;
        try {
            Date date = format.parse(time);
            dateL = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateL;
    }

    public static void main(String[] args){
//        System.out.print("时间毫秒：" + longForDate("2017-07-14 16:56:11" , "yyyy-MM-dd HH:mm:ss"));
        System.out.println(longForDate(System.currentTimeMillis() , "yyyy-MM-dd"));
    }
}
