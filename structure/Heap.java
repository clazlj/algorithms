package structure;

import java.util.Arrays;

/**
 * 二叉堆，完全二叉树
 * <p>
 * 完全二叉树：由满二叉树引出来的。设二叉树的深度为h，除第h层外，其他各层（1~h-1）的节点数都达到最大个数（即1~h-1层为一个满二叉树），
 * 第h层所有的节点都连续集中在最左边。
 * <p>
 * 满二叉树一定是完全二叉树。反之不然，即完全二叉树不一定是满二叉树。
 *
 * <p>
 * 顺序存储，存储在数组中
 * 索引从0开始：父节点索引为parent，左子节点索引为2*parent+1，右子节点索引为2*parent+2
 * 索引从1开始：父节点索引为parent，左子节点索引为2*parent，右子节点索引为2*parent+1
 */
public class Heap {

    /**
     * "上浮"调整
     * 优化点：父节点和孩子节点做连续交换时，没有真的交换，最后才实际交换。
     *
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;

        int temp = array[childIndex];
        // parentIndex>=0的判断可能会死循环。(0-1)/2=0
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];

            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        // TODO: 2024/11/3 下沉
    }
}
