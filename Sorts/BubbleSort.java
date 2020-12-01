package Sorts;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        Integer[] intArr = {5, 3, 6, 7, 4, 2, 1, 9, 8};
        System.out.println("原始intArr：" + Arrays.toString(intArr));
        sortArr(intArr);
        System.out.println("排序后intArr：" + Arrays.toString(intArr));

        String[] strArr = {"ff", "gg", "f13", "12mx"};
        System.out.println("原始strArr：" + Arrays.toString(strArr));
        sortArr(strArr);
        System.out.println("排序后strArr：" + Arrays.toString(strArr));
    }

    private static <T extends Comparable<T>> void sortArr(T[] arr) {
        if (arr == null) {
            return;
        }
        int len = arr.length;
        //每次找出一个最大的，共需找到n-1个较大的。
        for (int i = 1; i <= len - 1; i++) {
            //标记位：每个相邻元素已排好序
            boolean swapped = false;
            //第1批j<=len-1-1
            //第2批j<=len-1-2
            //第3批j<=len-1-3
            for (int j = 0; j <= len - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
