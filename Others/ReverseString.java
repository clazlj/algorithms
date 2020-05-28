package Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符串");
        String oriStr = br.readLine();
        String result = reverse(oriStr);
        System.out.println("原字符串为" + oriStr);
        System.out.println("倒序字符串为" + result);

        br.close();
    }

    private static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }
}
