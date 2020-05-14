package com.bigdata.display.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author like
 * @version 1.0
 * @date 2020/5/14 16:19
 */
public class TimeUtil {

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
}
