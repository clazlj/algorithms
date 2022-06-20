package Search;

/**
 * 一个int[]中只有一个数出现了奇数次，其余的数都出现了偶数次。
 * 找出出现了奇数次的这一个数
 * 开心消消乐？
 */
public class OddCountNumSearch {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{5, 6, 7, 6, 8, 6, 5, 7, 8};
        int num = getNum(arr);
        System.out.printf("出现奇数次的数为%s", num);
    }

    /**
     * 异或可以看作是无进位相加
     * 异或：1，满足交换律。2，自己与自己异或结果是0。3，数字x与0异或的结果是x
     * 综上：出现偶数次的数异或之后的结果是0。出现奇数次的数前偶数次结果为0，最终0与最后一次的数异或得到结果
     */
    public static int getNum(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) {
            throw new Exception("参数异常");
        }
        int result = 0;
        for (int i : arr) {
            result = result ^ i;
        }
        return result;
    }
}
