package structure;

/**
 * @author cl
 * @create 2021-07-21 13:52
 *
 *        1
 *      *   *
 *   2        3
 *          *   *
 *        4       5
 *
 *
 **/
public class BinaryTree {
    public static void main(String[] args) {
        HeroNode rootNode = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "卢俊义");
        HeroNode node3 = new HeroNode(3, "吴用");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "柴进");

        //手动
        rootNode.left = node2;
        rootNode.right = node3;
        node3.left = node4;
        node3.right = node5;

        BinaryTree tree = new BinaryTree(rootNode);
        System.out.println("前序遍历结果：");
        tree.preOrder();
        System.out.println("-----------");

        System.out.println("中序遍历结果：");
        tree.infixOrder();
        System.out.println("-----------");

        System.out.println("后序遍历结果：");
        tree.postOrder();
        System.out.println("-----------");
    }

    private HeroNode rootNode;

    public BinaryTree(HeroNode rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.rootNode != null) {
            this.rootNode.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.rootNode != null) {
            this.rootNode.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.rootNode != null) {
            this.rootNode.postOrder();
        }
    }

    static class HeroNode {
        private int no;
        private String name;
        private HeroNode left;
        private HeroNode right;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        /**
         * 父节点，左子树，右子树
         */
        public void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        /**
         * 左子树，父节点，右子树
         */
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        /**
         * 左子树，右子树，父节点
         */
        public void postOrder() {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.println(this);
        }
    }
}

