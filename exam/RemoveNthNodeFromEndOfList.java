package exam;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode newHeadNode = removeNthFromEnd(head, 2);
    }

    /**
     * 删除链表的倒数第 N 个结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode curNode = head;
        do {
            nodeList.add(curNode);
        } while ((curNode = curNode.next) != null);

        int removeIndex = nodeList.size() - n;
        ListNode removeNode = nodeList.get(removeIndex);

        ListNode newHead;
        if (removeIndex == 0) {
            //首位
            newHead = removeNode.next;
            removeNode.next = null;
        } else if (removeIndex == nodeList.size() - 1) {
            //多个节点的末位
            newHead = head;
            nodeList.get(removeIndex - 1).next = null;
        } else {
            //多个节点的中间位
            newHead = head;
            nodeList.get(removeIndex - 1).next = removeNode.next;
            removeNode.next = null;
        }

        return newHead;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
