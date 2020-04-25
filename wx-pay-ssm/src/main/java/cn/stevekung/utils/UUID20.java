package cn.stevekung.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UUID20 {
    public static Long getUUID20(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String prefix = sdf.format(date);
        String suffix = "";
        String result = prefix + suffix;
        Long ans = Long.valueOf(result);
        return ans;
    }
}
