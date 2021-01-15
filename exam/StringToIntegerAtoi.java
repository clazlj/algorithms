package exam;

import java.util.ArrayList;
import java.util.List;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  231 − 1 或 −231 。
 *  
 *
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 *
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 *
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示：
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字、' '、'+'、'-' 和 '.' 组成
 */
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        System.out.println(stringToInt("+-"));
        System.out.println(stringToInt("+3.1526"));
        System.out.println(stringToInt("+0 123"));
        System.out.println(stringToInt(" -10 345"));
        System.out.println(stringToInt("20000000000000000000"));
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了13.71%的用户
     *
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了57.87%的用户
     */
    private static int stringToInt(String str) {
        int length = str.length();
        if (length == 0) {
            return 0;
        }

        char[] chars = new char[length];
        char[] oriChars = str.toCharArray();
        int charIndex = 0;
        boolean foundChar = false;

        for (int i = 0; i < oriChars.length; i++) {
            char c = oriChars[i];
            if (c == ' ' && !foundChar) {
                continue;
            }

            boolean isDigit = c >= '0' && c <= '9';
            if (!isDigit) {
                if (!foundChar) {
                    boolean fuhao = c == '+' || c == '-';
                    if (!fuhao) {
                        break;
                    }
                } else {
                    break;
                }
            }
            foundChar = true;
            chars[charIndex++] = c;
        }

        int result = 0;
        String resultStr = String.valueOf(chars).replace('\u0000', ' ').replace(" ", "");
        if (resultStr.length() != 0 && !resultStr.equals("+") && !resultStr.equals("-")) {
            try {
                result = Integer.parseInt(resultStr);
            } catch (NumberFormatException e) {
                if (resultStr.startsWith("-")) {
                    result = Integer.MIN_VALUE;
                } else {
                    result = Integer.MAX_VALUE;
                }
            }
        }

        return result;
    }


    /**
     * 初版，被各种test虐
     */
    private static int getStringToInt(String str) {
        str = str.replace(" ", "");
        if (str.length() == 0) {
            return 0;
        }
        if (str.startsWith("0") || str.startsWith("+0") || str.startsWith("-0")) {
            return 0;
        }
        if (str.startsWith(".") || str.startsWith("+-") || str.startsWith("-+")) {
            return 0;
        }
        char c = str.charAt(0);
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            return 0;
        }

        List<Character> characterList = new ArrayList<>(200);

        boolean existNum = false;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            String s = String.valueOf(aChar);
            if (s.equals(".")) {
                break;
            }
            boolean isNum = aChar >= '0' && aChar <= '9';
            if (isNum) {
                existNum = true;
                characterList.add(aChar);
            } else if (i == 0) {
                if (s.equals("+") || s.equals("-")) {
                    characterList.add(aChar);
                }
            }
        }

        if (!existNum) {
            return 0;
        }

        char[] resultCharArr = new char[characterList.size()];
        for (int i = 0; i < characterList.size(); i++) {
            resultCharArr[i] = characterList.get(i);
        }

        long longResult = Long.parseLong(String.valueOf(resultCharArr));
        int result = (int) longResult;
        if (result == longResult) {
            return result;
        }

        return longResult < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
}
