package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/19 22:17
 **/

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class solution203 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 确定新头部节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 删除链表中的节点
        if (head != null) {
            ListNode ptr = head.next;
            ListNode prev = head;
            // 删除链表中的节点
            while (ptr != null) {
                if (ptr.val == val) {
                    prev.next = ptr.next;
                    ptr = ptr.next;
                    continue;
                }
                ptr = ptr.next;
                prev = prev.next;
            }
        }
        return head;
    }
}
