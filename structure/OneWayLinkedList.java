package structure;

/**
 * 单向链表
 * @author cl
 * @create 2021-06-04 11:58
 **/
public class OneWayLinkedList {
    public static void main(String[] args) {
        HeroNode headNode = getHeadNode();

        listNode(headNode);

        reverseNode(headNode);
        listNode(headNode);
    }


    private static HeroNode getHeadNode() {
        HeroNode headNode = new HeroNode(-1, null, null);

        /*headNode.addNode(new HeroNode(1, "宋江", "及时雨"));
        headNode.addNode(new HeroNode(3, "吴用", "智多星"));
        headNode.addNode(new HeroNode(2, "卢俊义", "玉麒麟"));
        headNode.addNode(new HeroNode(1, "宋江", "及时雨"));
        headNode.addNode(new HeroNode(3, "吴用", "智多星"));*/


        headNode.addNodeByOrder(new HeroNode(2, "卢俊义", "玉麒麟"));
        headNode.addNodeByOrder(new HeroNode(1, "宋江", "及时雨"));
        headNode.addNodeByOrder(new HeroNode(3, "吴用", "智多星"));
        headNode.addNodeByOrder(new HeroNode(1, "宋江", "及时雨"));
        headNode.addNodeByOrder(new HeroNode(3, "吴用", "智多星"));

        return headNode;
    }

    private static void listNode(HeroNode headNode) {
        System.out.println("遍历单向链表结果：");
        HeroNode cur = headNode.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

    private static void reverseNode(HeroNode headNode) {
        System.out.println("反转单向链表");
        HeroNode newHeadNode = new HeroNode(-1, null, null);

        while (headNode.next != null) {
            HeroNode toRemoveNode = headNode.next;
            headNode.next = toRemoveNode.next;

            toRemoveNode.next = newHeadNode.next;
            newHeadNode.next = toRemoveNode;
        }

        headNode.next = newHeadNode.next;
        newHeadNode.next = null;
    }


    public static void addNode(HeroNode headNode, HeroNode newNode) {
        HeroNode temp = headNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    static class HeroNode {
        private int no;

        private String name;

        private String nickName;

        private HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }

        void addNode(HeroNode newNode) {
            HeroNode temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        void addNodeByOrder(HeroNode newNode) {
            HeroNode temp = this;
            while (temp.next != null && temp.next.no <= newNode.no) {
                temp = temp.next;
            }
            if (temp.no == newNode.no) {
                System.out.printf("%s已存在，无需再添加\n", temp);
                return;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
}


