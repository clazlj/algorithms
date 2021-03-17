package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));

        System.out.println(isValid("(([]){})"));
    }

    //遇到左括号入栈
    //遇到右括号则此时栈必须非空，让左括号出栈，如不匹配则不是
    //最后栈空了则是有效的
    public static boolean isValid(String s){
        Map<Character, Character> dic = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> leftCharStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                leftCharStack.push(aChar);
                continue;
            }
            if (leftCharStack.empty()) {
                return false;
            }
            Character pop = leftCharStack.pop();
            if (!pop.equals(dic.get(aChar))) {
                return false;
            }
        }
        return leftCharStack.empty();
    }

    /**
     * (([]){})测试失败
     */
    public static boolean isValid0(String s) {
        Map<Character, Character> dic = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        char[] chars = s.toCharArray();
        int leftIndex = 0, rightIndex = chars.length - 1;
        while (leftIndex < rightIndex) {
            char leftChar = chars[leftIndex];
            Character leftFilterChar = dic.get(leftChar);
            if (leftFilterChar == null) {
                return false;
            }
            char nextChar = chars[leftIndex + 1];
            if (nextChar == '(' || nextChar == '[' || nextChar == '{') {
                if (chars[rightIndex] == leftFilterChar) {
                    leftIndex++;
                    rightIndex--;
                } else {
                    return false;
                }
            } else if (nextChar == leftFilterChar) {
                leftIndex = leftIndex + 2;
            } else {
                return false;
            }
        }

        return leftIndex - 1 == rightIndex;
    }
}
