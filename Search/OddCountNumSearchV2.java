package Search;

/**
 * 常规操作：一个非0的数x取反+1后与上自己，得到一个新的数：x最后一位的1不变，其余位变为0
 * 一个int[]中只有2个数出现了奇数次，其余的数都出现了偶数次。
 * 找出出现了奇数次的这2个数
 */
public class OddCountNumSearchV2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 1, 2, 3, 2, 3, 5, 5, 6, 6, 6, 6};
        printTwoNum(arr);
    }

    /**
     * 一个非0的数x取反+1后与上自己，得到一个新的数：x最后一位的1不变，其余位变为0
     * @see OddCountNumSearch 假设两个数是a和b，其余的数统称为others，全部异或得到a^b。
     */
    public static void printTwoNum(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
        }
        //xor现在值为a^b。由题设得知a!=b，则xor!=0。所以xor一定有1位是1，且a和b在这1位上的值是不一样的。

        //把这1位上是1和0的数分为两类others1和others2，假设a和others1在一组，b和others2在另一组。

        //根据xor得到一个新的数：xor最后一位的1不变，其余位变为0。记作rightOne。
        int rightOne = xor & (~xor + 1);
        //假设rightOne==0000100。
        int xor1 = 0;
        for (int i : arr) {
            if ((i & rightOne) == 0) {
                //说明i的倒数第3位是0，假设这是a或others1。
                // 由题意可知others1出现了偶数次，所有异或的最终结果是0。所以最终的xor1=0^a=a。
                xor1 = xor1 ^ i;
            }
        }
        // 此时的xor1=a，则b=xor^xor1=a^b^a
        System.out.printf("一个数是%s，另一个数是%s", xor1, xor ^ xor1);
    }
}
