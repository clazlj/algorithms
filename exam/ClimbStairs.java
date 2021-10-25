package exam;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或2级台阶。计算一共有多少种走法
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int stairCount = 30;

        long start = System.currentTimeMillis();
        int recurseCount = recurseGetClimbingWays(stairCount);
        System.out.println("递归算法求解为" + recurseCount + "，耗时" + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        int recurseCountWithCache = recurseGetClimbingWaysWithCache(stairCount, new HashMap<>());
        System.out.println("备忘录（带缓存的递归）算法求解为" + recurseCountWithCache + "，耗时" + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        int dynamicCount = getClimbingWaysDynamic(stairCount);
        System.out.println("动态规划算法求解为" + dynamicCount + "，耗时" + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * 10级台阶：最后一步是从8级到10级的走法有X种，最后一步是从9级到10级的走法有Y种。则为X+Y种走法。转换成分别求8级台阶和9级台阶的走法，对其求和。
     * 9级台阶： 最后一步是从7级到9级的走法有X种，最后一步是从8级到9级的走法有Y种。则为X+Y种走法。转换成分别求7级台阶和8级台阶的走法，对其求和。
     * 以此类推。。。
     * 1级台阶的走法有1种，2级台阶的走法有2种
     * 采用递归法
     * 问题：F(n)=F(n-1)+F(n-2)，F(n-1)=F(n-2)+F(n-3)...，
     *                                                      F(n)
     *                              F(n-1)                                              F(n-2)
     *              F(n-2)                      F(n-3)                   F(n-3)                     F(n-4)
     *     F(n-3)          F(n-4)      F(n-4)           F(n-5)   F(n-4)           F(n-5)    F(n-5)              F(n-6)
     *   发现中间台阶数的走法存在大量重复计算
     *   其实是一个二叉树。输的高度是n-1，节点个数接近2的n-1次方。时间复杂度近似看成O(2^N)
     *
     */
    private static int recurseGetClimbingWays(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return recurseGetClimbingWays(n - 1) + recurseGetClimbingWays(n - 2);
    }

    /**
     * 备忘录算法
     * 递归算法的优化版（缓存中间结果，防止重复计算）
     * tempResultMap是一个备忘录，优先从其中取结果
     * 从F(1)到F(N)一共有 N个不同的输入，在tempResultMap中存了N-2个结果。时间、空间复杂度是O(N)
     */
    private static int recurseGetClimbingWaysWithCache(int n, Map<Integer, Integer> tempResultMap) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        Integer cacheCount = tempResultMap.get(n);
        if (cacheCount != null) {
            return cacheCount;
        }
        int result = recurseGetClimbingWaysWithCache(n - 1, tempResultMap) + recurseGetClimbingWaysWithCache(n - 2, tempResultMap);
        tempResultMap.put(n, result);
        return result;
    }


    /**
     * 动态规划算法
     * 从第3阶开始，每次保留之前的两个阶数值，对其求和
     */
    private static int getClimbingWaysDynamic(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int tempResult = 0;
        for (int i = 3; i <= n; i++) {
            tempResult = a + b;
            a = b;
            b = tempResult;
        }
        return tempResult;
    }
}
