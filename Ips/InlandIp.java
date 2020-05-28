package Ips;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class InlandIp {
    private static final int[][] range = {
            //36.56.0.0-36.63.255.255
            {607649792, 608174079},
            //61.232.0.0-61.237.255.255
            {1038614528, 1039007743},
            // 106.80.0.0-106.95.255.255
            {1783627776, 1784676351},
            // 121.76.0.0-121.77.255.255
            {2035023872, 2035154943},
            // 123.232.0.0-123.235.255.255
            {2078801920, 2079064063},
            // 139.196.0.0-139.215.255.255
            {-1950089216, -1948778497},
            // 171.8.0.0-171.15.255.255
            {-1425539072, -1425014785},
            // 182.80.0.0-182.92.255.255
            {-1236271104, -1235419137},
            // 210.25.0.0-210.47.255.255
            {-770113536, -768606209},
            // 222.16.0.0-222.95.255.255
            {-569376768, -564133889},
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要的ip个数");
        int count = sc.nextInt();
        System.out.println("结果：");

        for (int i = 1; i <= count; i++) {
            Random rdint = ThreadLocalRandom.current();
            int index = rdint.nextInt(10);
            String ip = num2ip(range[index][0] + rdint.nextInt(range[index][1] - range[index][0]));
            System.out.println(ip);
        }
    }

    /**
     * 将十进制转换成ip地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];

        b[0] = ((ip >> 24) & 0xff);
        b[1] = ((ip >> 16) & 0xff);
        b[2] = ((ip >> 8) & 0xff);
        b[3] = (ip & 0xff);

        return b[0] + "." + b[1] + "." + b[2] + "." + b[3];
    }
}
