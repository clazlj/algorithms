package exam;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了94.82%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了78.37%的用户
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closeNum = 0;
        int closeSum = 0;

        boolean findTarget = false;
        for (int i = 0; i < nums.length; i++) {
            if (findTarget) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1, R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];

                if (sum == target) {
                    findTarget = true;
                    closeSum = sum;
                    break;
                }
                int curCloseNum = sum - target > 0 ? sum - target : target - sum;
                if (closeNum == 0 || curCloseNum < closeNum) {
                    closeNum = curCloseNum;
                    closeSum = sum;
                }

                if (sum < target) {
                    L++;
                } else {
                    R--;
                }
            }
        }

        return closeSum;
    }

}
