package Sorts;

import java.util.Arrays;

/**
 * 荷兰国旗问题：荷兰国旗从上到下有3种颜色
 * 给定一个数组arr和一个数x，要求数组左侧的数小于x，中间部分的数等于x，右侧部分的数大于x。
 * 额外空间复杂度O(1)，时间复杂度O(N)
 *
 * 简单版本：给定一个数组arr和一个数x，要求数组左侧的数小于等于x，右侧部分的数大于x。
 */
public class DutchNationalFlagProblem {
    // TODO: 2022/7/10 仅自测通过
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 3, 6, 4, 9, 7, 5, 8, 7};
        int x = 7;

        //等于x的不一定在中间
        easyVersion(arr, x);

        //等于x的要求在中间
        dutchNationFlag(arr, x);
    }

    /**
     * 给定一个数组arr和一个数x，要求数组左侧的数小于等于x，右侧部分的数大于x。
     */
    private static void easyVersion(int[] arr, int x) {
        int leftBorder = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                swap(arr, ++leftBorder, i);
            }
        }
        System.out.println("easyVersion:" + Arrays.toString(arr));
    }

    /**
     * 给定一个数组arr和一个数x，要求数组左侧的数小于x，中间部分的数等于x，右侧部分的数大于x。
     */
    private static void dutchNationFlag(int[] arr, int x) {
        int leftBorder = -1, middleBorder = -1;
        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];
            if (currentNum < x) {
                swap(arr, ++leftBorder, i);
                if (middleBorder > -1) {
                    //存在等于x的数
                    middleBorder++;
                }
            } else if (currentNum == x) {
                middleBorder = i;
            }
        }
        System.out.println("dutchNationFlag:" + Arrays.toString(arr));
    }

    private static void swap(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
