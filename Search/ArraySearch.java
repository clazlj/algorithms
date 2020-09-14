package Search;

import java.util.Arrays;

public class ArraySearch {
    public static void main(String[] args) {
        char[] e = {'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B'};

        // 排序后再进行二分查找，否则找不到
        Arrays.sort(e);
        System.out.println("Arrays.sort(e)" + Arrays.toString(e));

        char destChar = 'A';
        System.out.println(String.format("Arrays.binarySearch(e, '%s')：", destChar));
        int s = Arrays.binarySearch(e, destChar);

        System.out.println(String.format("数组中%s字符%s", s > -1 ? "存在" : "不存在", destChar));
    }
}
