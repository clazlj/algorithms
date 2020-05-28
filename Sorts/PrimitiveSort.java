package Sorts;

import java.util.Arrays;

public class PrimitiveSort {
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
        for (int i = 0; i <= len - 2; i++) {
            for (int j = i + 1; j <= len - 1; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
