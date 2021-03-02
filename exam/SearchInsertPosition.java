package exam;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));

        System.out.println(searchInsert(new int[]{1, 3}, 2));


    }

    /**
     * 本方法定义 target是在一个在左闭右闭的区间里，也就是[left, right]
     */
    public static int searchInsert(int[] nums, int target) {
        // 我们定义target在左闭右闭的区间里，[left, right]，
        // 这个区间的定义就是我们的不变量，
        // 接下来，要在下面的循环中，坚持这个不变量，我们就知道其中的边界条件应该怎么判断了
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {  //因为当left==right，区间[left, right]依然有效
            int middle = (left + right) >> 1; //等效于/2
            int num = nums[middle];
            if (num == target) {
                index = middle;
                break;
            } else if (num < target) {
                left = middle + 1; //target在右区间，所以[middle + 1, right]
            } else {
                //target在左区间，因为我们的区间是左闭右闭的区间，nums[middle]一定不是我们的目标值，
                //所以在right = middle - 1在[left, middle - 1]区间中继续寻找目标值
                right = middle - 1;
            }
        }

        // 分别处理如下四种情况
        // 目标值在数组所有元素之前，此时区间为[0, -1]，所以return right + 1
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置，一定是我们查找的范围 [left, right]之后，return right + 1
        // 目标值在数组所有元素之后的情况，也是我们查找的范围 [left, right]之后， return right + 1
        if (index >= 0) {
            return index;
        }

        return right + 1;
    }

    /**
     * 本方法定义 target 是在一个在左闭右开的区间里，也就是[left, right)
     */
    public static int searchInsertV2(int[] nums, int target) {
        // 我们定义target在左闭右开的区间里，[left, right)，
        // 这个区间的定义就是我们的不变量，
        // 接下来，要在下面的循环中，坚持这个不变量，我们就知道其中的边界条件应该怎么判断了
        int left = 0, right = nums.length;
        int index = -1;
        while (left < right) {  //因为当left==right，区间[left, right)是无效的
            int middle = (left + right) >> 1; //等效于/2
            int num = nums[middle];
            if (num == target) {
                index = middle;
                break;
            } else if (num < target) {
                left = middle + 1; // target 在右区间，在 [middle+1, right)中
            } else {
                //target 在左区间，因为是左闭右开的区间，nums[middle]一定不是我们的目标值，
                //所以right = middle，在[left, middle)中继续寻找目标值
                right = middle;
            }
        }

        // 分别处理如下四种情况
        // 目标值在数组所有元素之前，此时区间为[0, 0)，所以return right
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right) ，return right 即可
        // 目标值在数组所有元素之后的情况 [left, right)，return right 即可
        if (index >= 0) {
            return index;
        }

        return right;
    }

}
