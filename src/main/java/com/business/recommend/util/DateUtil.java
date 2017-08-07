package com.business.recommend.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhh");

    /**
     * 获取yyMMddhh的时间串
     */
    public static String getDateSequence() {
        return sdf.format(new Date());
    }

    public static Long getCurrentTime() {
        return new Date().getTime();
    }

    public static String getYY_MM_DDHHmmss(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String getYYMMDD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public static String getYYYY_MM(int n) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        for (int i = 1; i <= n; i++) {
            month = month + 1;
            if (month > 12) {
                year += 1;
                month = 1;
            }
        }
        String monthStr = month + "";
        if (month < 10) {
            monthStr = "0" + monthStr;
        }
        return year + "-" + monthStr;
    }

    public static String getYYYYMMDD() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String getYYMMDD() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public static String getYYMM() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }

    public static String getYYMMDDHHMMSS() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }


    public static String getHHMMSS_SSS() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss_SSS");
        return sdf.format(date);
    }

    public static String getYY_MM_DDHHmm(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }

    public static Date getDateFormat(String dateStr, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static Date attemptFormat(String dateStr) {
        if (dateStr.contains("T")) {
            return getDateFormat(dateStr.substring(0, 10) + " " + dateStr.substring(11, 19), "yyyy-MM-dd HH:mm:ss");
        }
        if (getDateFormat(dateStr, "yyyy/MM/dd HH:mm:ss") != null) {
            return getDateFormat(dateStr, "yyyy/MM/dd HH:mm:ss");
        }
        if (getDateFormat(dateStr, "yyyy/MM/dd HH:mm") != null) {
            return getDateFormat(dateStr, "yyyy/MM/dd HH:mm");
        }
        if (getDateFormat(dateStr, "yyyy/MM/dd") != null) {
            return getDateFormat(dateStr, "yyyy/MM/dd");
        }
        return null;
    }

    /**
     * 获取当前毫秒值
     *
     * @return yyyyMMddHHmmssSSS
     */
    public static String getNowTimeSSS() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS"); //精确到毫秒
        return fmt.format(new Date());
    }

    /**
     * 对字符串处理，返回格式：yy/MM/dd HH:mm:ss
     *
     * @return
     */
    public static String attemptFormatStr(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = attemptFormat(dateStr);
        if (date != null) {
            return sdf.format(date);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getYYMM());
    }

    /**
     * 对字符串处理，参数：yyyy-mm-dd hh24:mm:ss 返回格式：yyyy/MM/dd HH:mm:ss
     * created by:changweijia
     * created date:2017-03-07
     * siebel日期格式转换，主要用于与siebel接口
     *
     * @return
     */
    public static String ymdhms2SiebelDataStr(String dateStr) throws Exception {

        if (dateStr == null || "".equals(dateStr)) {
            return "";
        } else {
            String siebelDataStr;
            try {
                if (getDateFormat(dateStr, "yyyy-MM-dd HH:mm:ss") != null) {
                    Date date = getDateFormat(dateStr, "yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    siebelDataStr = sdf2.format(date);
                } else if (getDateFormat(dateStr, "yyyy-MM-dd HH:mm") != null) {
                    Date date = getDateFormat(dateStr, "yyyy-MM-dd HH:mm");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
                    siebelDataStr = sdf2.format(date) + ":00";
                } else if (getDateFormat(dateStr, "yyyy-MM-dd HH") != null) {
                    Date date = getDateFormat(dateStr, "yyyy-MM-dd HH");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH");
                    siebelDataStr = sdf2.format(date) + ":00:00";
                } else if (getDateFormat(dateStr, "yyyy-MM-dd") != null) {
                    Date date = getDateFormat(dateStr, "yyyy-MM-dd");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
                    siebelDataStr = sdf2.format(date) + " 00:00:00";
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                throw new Exception("转换siebel日期格式异常!传入参数:'" + dateStr + "'");
            }

            return siebelDataStr;
        }
    }

    /**
     * 对字符串处理，参数：yyyymmdd
     * created by:changweijia
     * created date:2017-03-22
     * siebel日期格式转换，主要用于与企点接口
     *
     * @return
     */
    public static String ymd2dateymdStr(String dateStr) throws Exception {
        String newDataStr = "";
        try {
            if (dateStr != null && dateStr.length() == 8) {
                Date date = getDateFormat(dateStr, "yyyyMMdd");
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                newDataStr = sdf2.format(date);
            }
        } catch (Exception e) {
            throw new Exception("转换日期格式异常!传入参数:'" + dateStr + "'");
        }
        return newDataStr;
    }

    /**
     * 对字符串处理，参数：时间戳 类似new Date().getTime()
     * created by:changweijia
     * created date:2017-03-22
     * siebel日期格式转换，主要用于与企点接口
     *
     * @return
     */
    public static String timeStempStr2FormatStr(String dateStemp, String dateFormat) throws Exception {
        String newTime = "";
        try {
            long l = Long.parseLong(dateStemp);
            Date d = new Date(l * 1000);
            if (dateFormat == null || dateFormat.length() <= 0) {
                dateFormat = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            return sdf.format(d);
        } catch (Exception e) {
            return newTime;
        }
    }
}
