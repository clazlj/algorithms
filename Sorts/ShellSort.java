package Sorts;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 希尔排序
 * 每趟的排序间隔逐步缩小，也可称为“缩小增量排序”
 * 可认为对插入排序进行的优化
 * 步长默认用最简单的不断除以2。但还有其他更好的步长，但暂还没有统一的标准。
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 1, 8, 9, 6, 7, 5};
        System.out.println("排序前：" + Arrays.toString(arr));
        sortArr(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("-------------------------");

        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        int size = 80_000;
//        size = 20;
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

        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                //步长step=1，就是最基本的插入排序
                int current = arr[i];
                int insertIndex = 0;
                //current依次和本组内的前一个元素比较，找寻自己可以插入的位置
                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > current) {
                        arr[j + step] = arr[j];
                        insertIndex = j;
                    } else {
                        insertIndex = j + step;
                        break;
                    }
                }
                arr[insertIndex] = current;
            }
        }
    }
}
