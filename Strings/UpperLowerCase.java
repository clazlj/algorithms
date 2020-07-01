package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperLowerCase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入字符串");
        String oriStr = br.readLine();
        String firstUpperStr = upperFirstLetter(oriStr);
        String lowerFirstLetter = lowerFirstLetter(oriStr);

        System.out.println("原字符串：".concat(oriStr));
        System.out.println("首字母大写：".concat(firstUpperStr));
        System.out.println("首字母小写：".concat(lowerFirstLetter));

        br.close();
    }

    private static String upperFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toUpperCase(str.charAt(0)));
        return sb.toString();
    }

    private static String lowerFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toLowerCase().concat(str.substring(1));
    }
}
