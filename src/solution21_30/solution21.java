package solution21_30;

/**
 * @Author Fisher
 * @Date 2019/7/27 10:23
 **/

/**
 * Question21：合并两个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution21 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        while (l1 != null) {
            ptr.next = l1;
            l1 = l1.next;
            ptr = ptr.next;
        }
        while (l2 != null) {
            ptr.next = l2;
            l2 = l2.next;
            ptr = ptr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
        node1.next = node2;
//        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(7);
//        ListNode node6 = new ListNode(4);
        node4.next = node5;
//        node5.next = node6;

        solution21 s21 = new solution21();
        ListNode result = s21.mergeTwoLists(node1, node4);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
