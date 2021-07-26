package structure;

/**
 * 顺序存储二叉树：通常只考虑完全二叉树
 * 也可以用数组实现顺序存储二叉树
 * 下图的数值代表数组索引
 *                        0
 *               1                 2
 *          3         4       5         6
 *       7    8    9    10  11  12   13    14
 *
 *   规律：假设父节点的索引为n，则其左子节点为2n+1，右子节点为2n+2
 */
public class ArrBinaryTree {
    public static void main(String[] args) {
        //数结构，数值代表实际值
//                1
//             2     3
//          4    5  6   7

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前序遍历");
        //1,2,4,5,3,6,7
        arrBinaryTree.preOrder();
        System.out.println("--------");

        System.out.println("中序遍历");
        //4,2,5,1,6,3,7
        arrBinaryTree.infixOrder();
        System.out.println("--------");

        System.out.println("后序遍历");
        //4,5,2,6,7,3,1
        arrBinaryTree.postOrder();
        System.out.println("--------");
    }

    private int[] arr;
    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (arr == null || arr.length == 0) {
            System.out.println("无元素");
        }
        preOrder(0);
    }
    private void preOrder(int index) {
        if (index >= 0 && index < arr.length) {
            System.out.println(arr[index]);

            this.preOrder(index * 2 + 1);

            this.preOrder(index * 2 + 2);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (arr == null || arr.length == 0) {
            System.out.println("无元素");
        }
        infixOrder(0);
    }
    private void infixOrder(int index) {
        if (index >= 0 && index < arr.length) {
            this.infixOrder(index * 2 + 1);

            System.out.println(arr[index]);

            this.infixOrder(index * 2 + 2);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (arr == null || arr.length == 0) {
            System.out.println("无元素");
        }
        postOrder(0);
    }
    private void postOrder(int index) {
        if (index >= 0 && index < arr.length) {
            this.postOrder(index * 2 + 1);

            this.postOrder(index * 2 + 2);

            System.out.println(arr[index]);
        }
    }

}
