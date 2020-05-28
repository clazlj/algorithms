package Maths;

import java.util.Scanner;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int num = sc.nextInt();
        boolean isPowerOfTwo = checkIfPowerOfTwo(num);

//        isPowerOfTwo = isPerfectSquare(num);

        if (isPowerOfTwo) {
            System.out.println(num + " is a power of Two");
        } else {
            System.out.println(num + " is not a power of Two");
        }

        sc.close();
    }

    /**
     * 炫酷
     */
    private static boolean checkIfPowerOfTwo(int number) {
        return number > 0 && (number & (number - 1)) == 0;
    }

    /**
     * 基本
     */
    private static boolean isPerfectSquare(int number) {
        if (number <= 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}
