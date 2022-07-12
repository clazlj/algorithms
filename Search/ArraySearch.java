package Search;

import java.util.Arrays;

public class ArraySearch {
    public static void main(String[] args) {
//        searchDemo();

        char[] e = {'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B'};

        // 排序后再进行二分查找，否则找不到
        Arrays.sort(e);
        System.out.println("Arrays.sort(e)" + Arrays.toString(e));

        char destChar = 'A';
        System.out.println(String.format("Arrays.binarySearch(e, '%s')：", destChar));
        int s = Arrays.binarySearch(e, destChar);

        System.out.printf("数组中%s字符%s%n", s > -1 ? "存在" : "不存在", destChar);

    }

    public static void searchDemo() {
        int[] arr = {5, 8, 9, 12, 23, 26, 56, 89, 189};
        int size = arr.length;
        int find = 89;

        int l = 0, r = size - 1;
        int index = -1;
        while (l <= r) {
            //代替(l+r)/2，防止溢出
            int mid = l + (r - l) / 2;
            int midVal = arr[mid];
            if (midVal > find) {
                r = mid - 1;
            } else if (midVal < find) {
                l = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        System.out.println("位置在" + index);
    }
}
