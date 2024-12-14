package gg.nierqiaodov.main;

import gg.nierqiaodov.util.GetAccess;
import gg.nierqiaodov.util.Logger;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * 计数器类，用于计算距离某个事件的剩余时间，并提供倒计时的字符串表示。
 */
public class Counter {

    // 定义静态变量，用于存储倒计时的天数、小时、分钟和秒
    static long days;
    static long hours;
    static long minutes;
    static long seconds;

    /**
     * 获取当前倒计时的天数。
     *
     * @return 当前倒计时的天数。
     */
    public static long getDays() {
        return days;
    }

    /**
     * 设置倒计时的天数。
     *
     * @param d 要设置的天数。
     */
    public static void setDays(long d) {
        days = d;
    }

    /**
     * 获取当前倒计时的小时数。
     *
     * @return 当前倒计时的小时数。
     */
    public static long getHours() {
        return hours;
    }

    /**
     * 设置倒计时的小时数。
     *
     * @param h 要设置的小时数。
     */
    public static void setHours(long h) {
        hours = h;
    }

    /**
     * 获取当前倒计时的分钟数。
     *
     * @return 当前倒计时的分钟数。
     */
    public static long getMinutes() {
        return minutes;
    }

    /**
     * 设置倒计时的分钟数。
     *
     * @param m 要设置的分钟数。
     */
    public static void setMinutes(long m) {
        minutes = m;
    }

    /**
     * 获取当前倒计时的秒数。
     *
     * @return 当前倒计时的秒数。
     */
    public static long getSeconds() {
        return seconds;
    }

    /**
     * 设置倒计时的秒数。
     *
     * @param s 要设置的秒数。
     */
    public static void setSeconds(long s) {
        seconds = s;
    }

    /*
      设置倒计时的时间。

      @param day   天数。
     * @param hour  小时数。
     * @param minute 分钟数。
     * @param second 秒数。
     */

    /**
     * 计算并返回倒计时的字符串表示。
     *
     * @return 倒计时的字符串表示，格式为 "天-时-分-秒"。
     */
    public static String setTime() {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        // 获取考试时间
        LocalDateTime examTime = LocalDateTime.of(GetAccess.getY(), GetAccess.getM(), GetAccess.getD(), GetAccess.getH(), 0);
        // 计算天数差
        long day = ChronoUnit.DAYS.between(now, examTime);
        // 计算小时差
        long hour = ChronoUnit.HOURS.between(now, examTime) % 24;
        // 计算分钟差
        long minute = ChronoUnit.MINUTES.between(now, examTime) % 60;
        // 计算秒差
        long second = ChronoUnit.SECONDS.between(now, examTime) % 60;

        // 设置倒计时的天数、小时、分钟和秒
        setDays(day);
        setHours(hour);
        setMinutes(minute);
        setSeconds(second);

        // 进入无限循环，不断更新倒计时
        while (true) {
            try {
                // 线程休眠1秒
                Thread.sleep(1000);
            } catch (Exception e) {
                // 捕获异常，退出程序
                System.exit(0);
            }
            // 如果秒数大于0，则秒数减1
            if (getSeconds() > 0) {
                setSeconds(getSeconds() - 1);
                // 记录日志，输出当前倒计时值
                Logger.logOut("当前倒计时值为" + days + "-" + hours + "-" + minutes + "-" + seconds);
            }
            // 如果秒数等于0，则将秒数设置为59
            else {
                setSeconds(60);
                setSeconds(getSeconds() - 1);
                // 记录日志，输出当前倒计时值
                Logger.logOut("当前倒计时值为" + days + "-" + hours + "-" + minutes + "-" + seconds);
                // 如果分钟数大于0，则分钟数减1
                if (getMinutes() > 0) {
                    setMinutes(getMinutes() - 1);
                    // 记录日志，输出当前倒计时值
                    Logger.logOut("当前倒计时值为" + days + "-" + hours + "-" + minutes + "-" + seconds);
                }
                // 如果分钟数等于0，则将分钟数设置为59
                else {
                    setMinutes(60);
                    // 记录日志，输出当前倒计时值
                    Logger.logOut("当前倒计时值为" + days + "-" + hours + "-" + minutes + "-" + seconds);
                    // 如果小时数大于0，则小时数减1
                    if (getHours() > 0) {
                        setHours(getHours() - 1);
                        // 记录日志，输出当前倒计时值
                        Logger.logOut("当前倒计时值为" + days + "-" + hours + "-" + minutes + "-" + seconds);
                    }
                    // 如果小时数等于0，则将小时数设置为23
                    else {
                        setHours(24);
                        // 记录日志，输出当前倒计时值
                        Logger.logOut("当前倒计时值为" + days + "-" + hours + "-" + minutes + "-" + seconds);
                        // 如果天数大于0，则天数减1
                        if (getDays() > 0) {
                            setDays(getDays() - 1);
                            // 记录日志，输出当前倒计时值
                            Logger.logOut("当前倒计时值为" + days + "-" + hours + "-" + minutes + "-" + seconds);
                        }
                    }
                }
            }
            // 返回倒计时的字符串表示
            return days + "天" + hours + "时" + minutes + "分" + seconds + "秒";
        }
    }
}