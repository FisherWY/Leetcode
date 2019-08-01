package solution21_30;

/**
 * @Author Fisher
 * @Date 2019/7/31 10:14
 **/

/**
 * Question24：两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 2->1->3->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution24 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode front = head;
        ListNode rear = head.next;
        ListNode res = rear;
        while (front!=null && rear!=null) {
            front.next = rear.next;
            rear.next = front;
            // 下一对节点不存在
            if (front.next == null || front.next.next == null) {
                return res;
            } else {
                // 先将上一对节点的尾部与下一对节点的尾部连接，再移动指针到下一对
                rear = front;
                front = front.next;
                rear.next = front.next;
                rear = front.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        solution24 s24 = new solution24();
        ListNode head = s24.swapPairs(node1);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
