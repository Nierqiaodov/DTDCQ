package gg.nierqiaodov.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    /**
     * 输出日志信息。
     *
     * @param logging 要记录的日志信息。
     */
    public static void logOut(String logging){

        // 获取当前时间
        Date date = new Date(System.currentTimeMillis());
        // 创建一个格式化日期对象，指定格式为 HH:mm:ss
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        // 将当前时间格式化为字符串
        String time = simpleDateFormat.format(date);

        // 输出日志信息，格式为 [DTDC log out 时间]:日志内容
        System.out.println("[DTDC log out " + time + "]:" + logging);

    }

}

