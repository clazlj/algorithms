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

        System.out.println("树自身递归前序遍历结果：");
        tree.preOrderInTree(rootNode);
        System.out.println("-----------");

        System.out.println("中序遍历结果：");
        tree.infixOrder();
        System.out.println("-----------");

        System.out.println("后序遍历结果：");
        tree.postOrder();
        System.out.println("-----------");

        int no = 2;
        System.out.println(String.format("开始前序查找：%s", no));
        HeroNode byPreNode = tree.getByPreOrder(no);
        System.out.println(String.format("前序查找：%s的结果是%s", no, byPreNode));
        System.out.println("-----------");

        //………………中序、后序查找
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

    public void preOrderInTree(HeroNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        preOrderInTree(node.left);
        preOrderInTree(node.right);
    }


    /**
     * 前序查找
     */
    public HeroNode getByPreOrder(int no) {
        if (this.rootNode != null) {
            return this.rootNode.getByPreOrder(no);
        }
        return null;
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.rootNode != null) {
            this.rootNode.infixOrder();
        }
    }

    //....中序查找

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.rootNode != null) {
            this.rootNode.postOrder();
        }
    }

    //....后序查找

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

        public HeroNode getByPreOrder(int no) {
            if (this.no == no) {
                return this;
            }
            if (this.left != null) {
                HeroNode node = this.left.getByPreOrder(no);
                if (node != null) {
                    return node;
                }
            }
            if (this.right != null) {
                return this.right.getByPreOrder(no);
            }
            return null;
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

