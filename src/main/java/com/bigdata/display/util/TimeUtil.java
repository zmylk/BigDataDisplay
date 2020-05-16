package com.bigdata.display.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author like
 * @version 1.0
 * @date 2020/5/14 16:19
 */
public class TimeUtil {

    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日";

    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getPeoleAge(Date birthday){
        Date today = new Date();
        return getYear(today)-getYear(birthday);
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static String getTimeString(Date date,String fommat) {
        SimpleDateFormat df = new SimpleDateFormat(fommat);
        return df.format(date);
    }


    /**
     * 获取当前时间Date格式
     */

    public static Date getTimeDate(String date,String fommat)  {
        SimpleDateFormat df = new SimpleDateFormat(fommat);
        Date parse = null;
        try {
            parse = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
