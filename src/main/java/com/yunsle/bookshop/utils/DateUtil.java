package com.yunsle.bookshop.utils;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Doublestar on 2018/1/11 22:27).
 */
@Component
public class DateUtil {
    /**
     * 时间戳字符串转Timestamp工具
     * @param str
     * @return
     */
    public Timestamp stringToTimestamp(String str) {
        long t = Long.parseLong(str);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(t);
        String datestr = simpleDateFormat.format(date);
        Timestamp ts = Timestamp.valueOf(datestr);
        return ts;
    }
}
