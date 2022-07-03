package Search;

import java.util.Arrays;
import java.util.Random;

/**
 * 找出数组中的最大数【非逐个遍历方法】
 */
public class MaxNumSearch {
    public static void main(String[] args) {
        // 跑多次验证
        for (int j = 0; j < 10; j++) {
            int length = 10;
            int numMax = 30;
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = new Random().nextInt(numMax);
            }
            int max = processMax(arr, 0, arr.length - 1);
            System.out.println("数组" + Arrays.toString(arr) + "的最大值为" + max);
        }
    }

    public static int processMax(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        //找出left与right的中点
        int middle = left + ((right - left) >> 1);
        int leftMax = processMax(arr, left, middle);
        int rightMax = processMax(arr, middle + 1, right);
        return Math.max(leftMax, rightMax);
    }
}
