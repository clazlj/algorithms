package structure;

/**
 * 单向链表
 * @author cl
 * @create 2021-06-04 11:58
 **/
public class OneWayLinkedList {
    public static void main(String[] args) {
        HeroNode headNode = getHeadNode();

        int lastCount = 2;
        HeroNode lastTopNode = getLastTopNode(headNode, lastCount);
        System.out.println("倒数第" + lastCount + "个节点是：" + lastTopNode);

        listNode(headNode);
        reverseNode(headNode);
        listNode(headNode);

        merge();
    }

    /**
     * 合并两个有序的单向列表
     */
    private static void merge() {
        HeroNode headNode1 = new HeroNode(-1, null, null);
        headNode1.addNodeByOrder(new HeroNode(1, "宋江", "及时雨"));
        headNode1.addNodeByOrder(new HeroNode(3, "吴用", "智多星"));
        headNode1.addNodeByOrder(new HeroNode(10, "十号人物", "老十"));


        HeroNode headNode2 = new HeroNode(-1, null, null);
        headNode2.addNodeByOrder(new HeroNode(2, "卢俊义", "玉麒麟"));
        headNode2.addNodeByOrder(new HeroNode(4, "柴静", "小旋风"));
        headNode2.addNodeByOrder(new HeroNode(5, "五号人物", "老五"));


        HeroNode mergeNode = new HeroNode(-1, null, null);
        HeroNode temp1 = headNode1.next;
        HeroNode temp2 = headNode2.next;
        HeroNode tempMerge = mergeNode;
        while (temp1 != null && temp2 != null) {
            if (temp1.no <= temp2.no) {
                tempMerge.next = temp1;
                tempMerge = temp1;
                temp1 = temp1.next;
            } else {
                tempMerge.next = temp2;
                tempMerge = temp2;
                temp2 = temp2.next;
            }
        }

        while (temp1 != null) {
            tempMerge.next = temp1;
            tempMerge = temp1;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            tempMerge.next = temp2;
            tempMerge = temp2;
            temp2 = temp2.next;
        }

        listNode(mergeNode);


    }


    private static HeroNode getLastTopNode(HeroNode headNode, int lastTop) {
        if (lastTop < 1 || headNode == null) {
            return null;
        }
        int fastStep = 0;
        HeroNode fastNode = headNode;
        HeroNode slowNode = null;

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            fastStep++;
            if (fastStep == lastTop) {
                slowNode = headNode.next;
            } else if (fastStep > lastTop) {
                slowNode = slowNode.next;
            }
        }

        return slowNode;
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


