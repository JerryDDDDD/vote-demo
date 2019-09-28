package com.layman.utils;

/**
 * @ClassName RandomStringUtil
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/2/16 19:44
 * @Version 3.0
 **/
public class RandomStringUtil {
    public static String generateRandomStr(int len) {
        //字符源，可以根据需要删减
        String generateSource = "0123456789";
        String rtnStr = "";
        for (int i = 0; i < len; i++) {
            //循环随机获得当次字符，并移走选出的字符
            String nowStr = String.valueOf(generateSource.charAt((int) Math.floor(Math.random() * generateSource.length())));
            rtnStr += nowStr;
            generateSource = generateSource.replaceAll(nowStr, "");
        }
        return rtnStr;
    }

    public static String bidNUmber()
    {
        String bidNum = "";
        // 用字符数组的方式随机
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] m = model.toCharArray();
        for (int j = 0; j < 6; j++) {
            char c = m[(int) (Math.random() * 62)];
            // 保证六位随机数之间没有重复的
            if (bidNum.contains(String.valueOf(c))) {
                j--;
                continue;
            }
            bidNum = bidNum + c;
        }
        return bidNum;
    }
}
