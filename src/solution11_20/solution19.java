package solution11_20;

/**
 * @Author Fisher
 * @Date 2019/7/26 9:59
 **/

/**
 * Question19：删除链表的倒数第n个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution19 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 设置一个开始指针
        ListNode startPtr = new ListNode(0);
        startPtr.next = head;
        ListNode currentNode = startPtr;
        ListNode toRemove = startPtr;
        // 当前指针先走n步
        while (n != 0) {
            currentNode = currentNode.next;
            n--;
        }
        // 当前指针和要删除的指示指针同步往下走
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            toRemove = toRemove.next;
        }
        toRemove.next = toRemove.next.next;
        return startPtr.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode ptr = head;
//        for (int i=2; i<=5; i++) {
//            ListNode node = new ListNode(i);
//            ptr.next = node;
//            ptr = ptr.next;
//        }

        solution19 s19 = new solution19();
        ListNode result = s19.removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }
}
