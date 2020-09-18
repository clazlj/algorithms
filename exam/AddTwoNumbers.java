package exam;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    private static ListNode addTwoNumbers(ListNode resultNode, ListNode curNode, ListNode l1, ListNode l2, int nextAdd) {
        if (l1 == null && l2 == null) {
            if (nextAdd > 0) {
                curNode.val = nextAdd;
            }
            return resultNode;
        }
        int l1Val = l1 == null ? 0 : l1.val;
        int l2Val = l2 == null ? 0 : l2.val;
        int sum = l1Val + l2Val + nextAdd;
        int remainder = sum % 10;
        nextAdd = sum >= 10 ? 1 : 0;

        ListNode l1Next = l1 != null ? l1.next : null;
        ListNode l2Next = l2 != null ? l2.next : null;
        boolean hasNextNode = l1Next != null || l2Next != null || nextAdd > 0;

        if (resultNode == null) {
            resultNode = new ListNode(remainder);
            if (hasNextNode) {
                resultNode.next = new ListNode(0);
            }
            return addTwoNumbers(resultNode, resultNode.next, l1Next, l2Next, nextAdd);
        } else {
            curNode.val = remainder;
            if (hasNextNode) {
                curNode.next = new ListNode(0);
            }
            return addTwoNumbers(resultNode, curNode.next, l1Next, l2Next, nextAdd);
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(null, null, l1, l2, 0);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }
}
