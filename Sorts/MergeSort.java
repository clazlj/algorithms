package Sorts;

import java.util.Arrays;

/**
 * @author cl
 * @create 2021-07-13 11:16
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 10, 5, 4, 3, 2, 1};

        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        if (arr == null) {
            return;
        }

        int length = arr.length;
        int[] temp = new int[length];
        sort(arr, 0, length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左序列
        int l = left;
        //右序列
        int r = mid + 1;
        //临时数组指针
        int t = 0;
        while (l <= mid && r <= right) {
//            if (arr[l] <= arr[r]) {
//                temp[t++] = arr[l++];
//            } else {
//                temp[t++] = arr[r++];
//            }
            temp[t++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }

        //两个while虽然是顺序写的，但实际只会一个while会被执行
        while (l <= mid) {
            temp[t++] = arr[l++];
        }
        while (r <= right) {
            temp[t++] = arr[r++];
        }

        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
