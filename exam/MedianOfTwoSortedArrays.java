package exam;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length1 = nums1.length, length2 = nums2.length;
//        int[] totalNums = length1 >= length2 ? nums1 : nums2;
//        int[] toMergeNums = length1 >= length2 ? nums2 : nums1;
//
//        int low = 0, high = totalNums.length - 1;
//        for (int toMergeNum : toMergeNums) {
//            while (low <= high) {
//                int mid = (low + high) >>> 1;
//                int midVal = totalNums[mid];
//                if (midVal < toMergeNum) {
//                    low = mid + 1;
//                } else if (midVal > toMergeNum) {
//                    high = mid - 1;
//                } else {
//
//                }
//            }
//        }
//
//        return 0;

        int length = nums1.length + nums2.length;
        int[] newnums = new int[length];

        int index1 = 0;
        int index2 = 0;
        int currrent = 0;

        while (index1 < nums1.length || index2 < nums2.length) {
            if (index2 >= nums2.length) {
                newnums[currrent++] = nums1[index1++];
                continue;
            }

            if (index1 >= nums1.length ) {
                newnums[currrent++] = nums2[index2++];
                continue;
            }

            if (nums1[index1] <= nums2[index2]) {
                newnums[currrent++] = nums1[index1++];
            } else {
                newnums[currrent++] = nums2[index2++];
            }
        }

        if (newnums.length % 2 == 0) {
            return ((double)(newnums[length /2] + newnums[length / 2 - 1])) / 2;
        } else {
            return ((double)newnums[length / 2]);
        }
    }
}
