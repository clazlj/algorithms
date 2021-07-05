package Sorts;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 1, 8, 9, 6, 7, 5};
        System.out.println("排序前：" + Arrays.toString(arr));
        sortArr(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("-------------------------");

        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        int size = 80_000;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = localRandom.nextInt(0, 80000);
        }

        boolean printArr = size <= 100;
        if (printArr) {
            System.out.println("排序前：" + Arrays.toString(arr));
        }
        long start = System.currentTimeMillis();
        sortArr(arr);
        long end = System.currentTimeMillis();

        if (printArr) {
            System.out.println("排序后：" + Arrays.toString(arr));
        }
        System.out.println(size + "个数排序耗时:" + (end - start) + "ms");


    }

    private static void sortArr(int[] arr) {
        if (arr == null) {
            return;
        }
        //把arr看成前后两部分，前面一部分是有序的，后面一部分是无序的
        //从第二个元素开始找，找它在有序部分的位置
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int insertIndex = i - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > current) {
                    //遍历的数大于当前寻找位置的数，遍历的数往后挪，位置腾给当前寻找位置的数
                    insertIndex = j;
                    arr[j + 1] = arr[j];
                } else {
                    //遍历的数<=当前寻找位置的数，说明位置已找到。遍历的数不动，当前寻找位置的数插在它后面
                    insertIndex = j + 1;
                    break;
                }
            }
            arr[insertIndex] = current;
        }
    }
}
