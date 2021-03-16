package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：答案中不可以包含重复的四元组。
 *
 *  
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 * 输入：nums = [], target = 0
 * 输出：[]
 *  
 *
 * 提示：
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));

        System.out.println(fourSum(new int[]{}, 0));

        System.out.println(fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    /**
     * 第三、第四个数用双指针
     */
    public static List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    int fourSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (fourSum < target) {
                        left++;
                    } else if (fourSum > target) {
                        right--;
                    } else {
                        List<Integer> filterList = new ArrayList<>();
                        filterList.add(nums[i]);
                        filterList.add(nums[j]);
                        filterList.add(nums[left]);
                        filterList.add(nums[right]);
                        resultList.add(filterList);
                        left++;
                        right--;
                    }
                }
            }
        }

        return resultList;
    }

    public static List<List<Integer>> fourSum0(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }

        boolean targetNotNegative = target >= 0;
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (targetNotNegative && nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (targetNotNegative && nums[i] + nums[j] > target) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (targetNotNegative && nums[i] + nums[j] + nums[k] > target) {
                        break;
                    }
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    for (int l = k + 1; l < nums.length; l++) {
                        int fourSum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (targetNotNegative && fourSum > target) {
                            break;
                        }
                        if (l > k + 1 && nums[l] == nums[l - 1]) {
                            continue;
                        }
                        if (fourSum == target) {
                            List<Integer> fourList = new ArrayList<>();
                            fourList.add(nums[i]);
                            fourList.add(nums[j]);
                            fourList.add(nums[k]);
                            fourList.add(nums[l]);
                            resultList.add(fourList);
                        }
                    }
                }
            }
        }

        return resultList;
    }
}
