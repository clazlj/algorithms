package exam;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶: 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome1(121));
    }


    /**
     * 执行用时：12 ms, 在所有 Java 提交中击败了33.07%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了11.81%的用户
     */
    public static boolean isPalindrome(int x) {
        String oriStr = String.valueOf(x);

        /*char[] chars = oriStr.toCharArray();
        char[] newChars = new char[chars.length];
        int j = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            newChars[j++] = chars[i];
        }
        String newStr = String.valueOf(newChars);

        return oriStr.equals(newStr);*/

        return new StringBuilder(oriStr).reverse().toString().equals(oriStr);
    }

    /**
     * 执行用时：15 ms, 在所有 Java 提交中击败了15.36%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了74.37%的用户
     */
    public static boolean isPalindrome1(int x){
        if (x < 0) {
            return false;
        }

        int reverseInt = 0;
        int length = String.valueOf(x).length();
        for (int i = 0; i < length; i++) {
            double pow = Math.pow(10, i);
            int v = (int) (x / pow) % 10;
            int reversePow = (int) Math.pow(10, length - 1 - i);
            reverseInt += v * reversePow;
        }

        return reverseInt == x;

    }
}
