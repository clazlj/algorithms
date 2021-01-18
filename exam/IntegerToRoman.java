package exam;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 * 输入: 3
 * 输出: "III"
 *
 * 示例 2:
 * 输入: 4
 * 输出: "IV"
 *
 * 示例 3:
 * 输入: 9
 * 输出: "IX"
 *
 * 示例 4:
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了51.97%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了92.16%的用户
     */
    public static String intToRoman_violence(int num) {
        StringBuilder romanStr = new StringBuilder();
        int thousand = num / 1000;
        for (int i = 0; i < thousand; i++) {
            romanStr.append("M");
        }

        num = num % 1000;
        int hundred = num / 100;
        //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        if (hundred == 4) {
            romanStr.append("CD");
        } else if (hundred == 9) {
            romanStr.append("CM");
        } else {
            //D=50
            if (hundred < 5) {
                for (int i = 0; i < hundred; i++) {
                    romanStr.append("C");
                }
            } else {
                romanStr.append("D");
                for (int i = 0; i < hundred - 5; i++) {
                    romanStr.append("C");
                }
            }
        }

        num = num % 100;
        int ten = num / 10;
        //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
        if (ten == 4) {
            romanStr.append("XL");
        } else if (ten == 9) {
            romanStr.append("XC");
        } else {
            //  L=50
            if (ten < 5) {
                for (int i = 0; i < ten; i++) {
                    romanStr.append("X");
                }
            } else {
                romanStr.append("L");
                for (int i = 0; i < ten - 5; i++) {
                    romanStr.append("X");
                }
            }
        }

        num = num % 10;
        int one = num;
        //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        if (one == 4) {
            romanStr.append("IV");
        } else if (one == 9) {
            romanStr.append("IX");
        } else {
            //I=1
            //V=5
            if (one < 5) {
                for (int i = 0; i < one; i++) {
                    romanStr.append("I");
                }
            } else {
                romanStr.append("V");
                for (int i = 0; i < one - 5; i++) {
                    romanStr.append("I");
                }
            }
        }

        return romanStr.toString();
    }

    public static String intToRoman(int num) {
        int[] keyValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] keyStrs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanStr = new StringBuilder();

        for (int i = 0; i < keyValues.length && num > 0; i++) {
            while (keyValues[i] <= num) {
                num -= keyValues[i];
                romanStr.append(keyStrs[i]);
            }
        }

        return romanStr.toString();
    }
}

