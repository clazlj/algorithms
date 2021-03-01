package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[] 
 *
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{}));
        System.out.println(threeSum(new int[]{0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //nums = [-1,0,1,2,-1,-4]
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();

        int numLength = nums.length;

        for (int i = 0; i <= numLength - 3; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //剩余两个数的首末两位
            int L = i + 1, R = numLength - 1;
            while (L < R) {
                if (L > i + 1 && nums[L] == nums[L - 1]) {
                    L++;
                    continue;
                }
                if (R < numLength - 1 && nums[R] == nums[R + 1]) {
                    R--;
                    continue;
                }
                int sum = nums[i] + nums[L] + nums[R];
                if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    List<Integer> filterList = new ArrayList<>();
                    filterList.add(nums[i]);
                    filterList.add(nums[L]);
                    filterList.add(nums[R]);

                    resultList.add(filterList);
                    L++;
                    R--;
                }
            }
        }

        return resultList;
    }

    /**
     * nums过大超时
     */
    public static List<List<Integer>> threeSum0(int[] nums) {
        //nums = [-1,0,1,2,-1,-4]
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();

        int numLength = nums.length;
        for (int i = 0; i <= numLength - 3; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= numLength - 2; j++) {
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k <= numLength - 1; k++) {
                    if (nums[i] + nums[j] + nums[k] > 0) {
                        break;
                    }
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int num1 = nums[i], num2 = nums[j], num3 = nums[k];
                    if (num1 + num2 + num3 == 0) {
                        List<Integer> filterList = new ArrayList<>();
                        filterList.add(num1);
                        filterList.add(num2);
                        filterList.add(num3);

                        resultList.add(filterList);
                    }
                }
            }
        }

        return resultList;
    }
}
