package Question3;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSet {
    //获取时间戳
    public static String getTimeStamp(long times) {
        Date date = new Date();
        times = date.getTime();
        return getFormatDate();
    }

    //获取格式化的时间
    public static String getFormatDate() {
        Date date = new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}