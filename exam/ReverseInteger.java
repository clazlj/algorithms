package exam;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseInteger {

    public static int reverse0(int x) {
        String intStr = String.valueOf(x);
        char firstChar = intStr.charAt(0);
        boolean isNegative = firstChar == '-';

        long result = 0;
        long multiply = 1;
        char[] chars = intStr.toCharArray();
        for (int i = isNegative ? 1 : 0; i < chars.length; i++) {
            //不能为Integer.parseInt，会导致乘了之后直接溢出
            result += Long.parseLong(String.valueOf(chars[i])) * multiply;
            multiply = multiply * 10;
        }
        if (isNegative) {
            result = -result;
        }

        int intResult = (int) result;
        return intResult == result ? intResult : 0;
    }

    public static int reverse(int x) {
        String intStr = String.valueOf(x);
        boolean isNegative = intStr.startsWith("-");
        StringBuilder intSb = new StringBuilder(isNegative ? intStr.substring(1) : intStr);
        intSb.reverse();

        StringBuilder resultSb = isNegative ? new StringBuilder("-").append(intSb) : intSb;

        int result = 0;
        try {
            result = Integer.valueOf(resultSb.toString());
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return result;
    }

    /**
     * 大牛解法
     */
    public static int betterReverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }


    public static void main(String[] args) {
        System.out.println(reverse0(1534236469));

        System.out.println(betterReverse(1534236469));

        System.out.println(reverse(1534236469));

        System.out.println(reverse(123));

        System.out.println(reverse(-123));

        System.out.println(reverse(120));


    }
}
