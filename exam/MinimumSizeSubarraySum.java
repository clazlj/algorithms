package exam;

/**
 * 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 *
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

    }

    // TODO: 2021/3/16  
    public static int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        int start = 0, end = 0;


        return min;
    }


        /**
         * 暴力循环
         */
    public static int minSubArrayLenV2(int target, int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (j > i) {
                    sum += nums[j];
                }
                if (sum >= target) {
                    int length = j - i + 1;
                    if (min == 0) {
                        min = length;
                    } else {
                        min = Math.min(min, length);
                    }
                    break;
                }
            }
        }
        return min;
    }
}
