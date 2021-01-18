package exam;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = []
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了17.42%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了91.89%的用户
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String firstStr = strs[0];
        if (firstStr.length() == 0) {
            return "";
        }

        String prefix = "";
        for (int i = 0; i < firstStr.length(); i++) {
            String tempPrefix = firstStr.substring(0, i + 1);
            int matchCount = 0;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].startsWith(tempPrefix)) {
                    matchCount++;
                } else {
                    break;
                }
            }
            if (matchCount == strs.length - 1) {
                prefix = tempPrefix;
            } else {
                break;
            }
        }

        return prefix;
    }
}
