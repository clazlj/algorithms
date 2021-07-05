package Sorts;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        Integer[] intArr = {5, 3, 6, 7, 4, 2, 1, 9, 8};
        System.out.println("原始intArr：" + Arrays.toString(intArr));
        sortArrWithLessSwap(intArr);
        System.out.println("排序后intArr：" + Arrays.toString(intArr));

        String[] strArr = {"ff", "gg", "f13", "12mx"};
        System.out.println("原始strArr：" + Arrays.toString(strArr));
        sortArrWithLessSwap(strArr);
        System.out.println("排序后strArr：" + Arrays.toString(strArr));
    }

    /**
     * 一找到就交换
     */
    private static <T extends Comparable<T>> void sortArr(T[] arr) {
        if (arr == null) {
            return;
        }
        int swapCount = 0;
        int len = arr.length;
        for (int i = 0; i <= len - 2; i++) {
            for (int j = i + 1; j <= len - 1; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    swapCount++;
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("sortArr交换次数：" + swapCount);

    }

    /**
     * 最终找到才交换
     */
    private static <T extends Comparable<T>> void sortArrWithLessSwap(T[] arr) {
        if (arr == null) {
            return;
        }
        int swapCount = 0;
        int len = arr.length;
        for (int i = 0; i <= len - 2; i++) {
            int minIndex = i;
            T min = arr[i];
            for (int j = i + 1; j <= len - 1; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                swapCount++;
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println("sortArrWithLessSwap交换次数：" + swapCount);
    }
}
