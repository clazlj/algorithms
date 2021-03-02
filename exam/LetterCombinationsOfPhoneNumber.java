package exam;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));


    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了83.69%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了92.07%的用户
     *
     *
     * !!!每次循环结束必须sb.deleteCharAt(sb.length() - 1);
     */
    public static List<String> letterCombinations(String digits) {
        //2->abc;3->def;4->ghi;5->jkl;6->mno;7->pqrs;8->tuv;9->wxyz
        Map<Character, List<String>> charStrMap = new HashMap<>();
        charStrMap.put('2', Arrays.asList("a", "b", "c"));
        charStrMap.put('3', Arrays.asList("d", "e", "f"));
        charStrMap.put('4', Arrays.asList("g", "h", "i"));
        charStrMap.put('5', Arrays.asList("j", "k", "l"));
        charStrMap.put('6', Arrays.asList("m", "n", "o"));
        charStrMap.put('7', Arrays.asList("p", "q", "r", "s"));
        charStrMap.put('8', Arrays.asList("t", "u", "v"));
        charStrMap.put('9', Arrays.asList("w", "x", "y", "z"));

        List<List<String>> letterList = new ArrayList<>();
        int length = digits.length();
        for (int i = 0; i < length; i++) {
            List<String> partList = charStrMap.get(digits.charAt(i));
            if (partList != null) {
                letterList.add(partList);
            }
        }

        List<String> result = new ArrayList<>();

        /*List<String> list1 = letterList.get(0);
        List<String> list2 = letterList.get(1);
        List<String> list3 = letterList.get(2);
        List<String> listN = letterList.get(letterList.size() - 1);

        for (String s : list1) {
            StringBuilder sb = new StringBuilder();

            sb.append(s);

            for (String s1 : list2) {
                sb.append(s1);

                for (String s2 : list3) {
                    sb.append(s2);

                    for (String s3 : listN) {
                        sb.append(s3);
                        result.add(sb.toString());
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.deleteCharAt(sb.length() - 1);

                }
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }*/

        if (letterList.size() > 0) {
            appendStr(letterList, 0, null, result);
        }

        return result;
    }

    private static void appendStr(List<List<String>> letterList, int curIndex, StringBuilder sb, List<String> resultList) {
        List<String> list = letterList.get(curIndex);
        for (String s : list) {
            if (curIndex == 0) {
                sb = new StringBuilder();
            }
            sb.append(s);

            if (curIndex < letterList.size() - 1) {
                appendStr(letterList, curIndex + 1, sb, resultList);
            }
            if (curIndex == letterList.size() - 1) {
                resultList.add(sb.toString());
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
