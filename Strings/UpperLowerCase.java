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

        System.out.println("原字符串：" + oriStr);
        System.out.println("首字母大写：" + firstUpperStr);

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
}
