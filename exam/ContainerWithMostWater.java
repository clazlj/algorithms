package exam;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 *  
 * 提示：
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxAreaBy2Point(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxAreaBy2Point(new int[]{1, 1}));
        System.out.println(maxAreaBy2Point(new int[]{4, 3, 2, 1, 4}));
        System.out.println(maxAreaBy2Point(new int[]{1, 2, 1}));

    }

    /**
     * 时间复杂度：O(N^2)
     * 执行用时：1008 ms, 在所有 Java 提交中击败了9.09%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了71.90%的用户
     */
    public static int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    /**
     * 双指针。
     * 时间复杂度：O(N)，双指针总计最多遍历整个数组一次。
     * 执行用时：4 ms, 在所有 Java 提交中击败了66.89%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了55.62%的用户
     */
    public static int maxAreaBy2Point(int[] height) {
        int l = 0, r = height.length - 1;

        int maxArea = (r - l) * Math.min(height[l], height[r]);
        while (l < r) {
            if (height[l] < height[r]) {
                int nextL = l + 1;
                if (height[nextL] > height[l]) {
                    int curArea = (r - nextL) * Math.min(height[nextL], height[r]);
                    maxArea = Math.max(maxArea, curArea);
                }
                l++;
            } else {
                int nextR = r - 1;
                if (height[nextR] > height[r]) {
                    int curArea = (nextR - l) * Math.min(height[nextR], height[l]);
                    maxArea = Math.max(maxArea, curArea);
                }
                r--;
            }
        }

        return maxArea;
    }
}
