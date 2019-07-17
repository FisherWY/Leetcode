package solution1_10;

/**
 * @Author Fisher
 * @Date 2019/7/15 17:19
 */

/**
 * Question2：两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 类似于数据结构中的大数加法
 */
public class solution2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode node = res, last = res;

        // 同位相加
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + node.val;
            node.val = sum % 10;
            node.next = new ListNode(sum / 10);
            last = node;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // l1剩余未加的位数，直接添加到链表中
        while (l1 != null) {
            int sum = l1.val + node.val;
            node.val = sum % 10;
            node.next = new ListNode(sum / 10);
            last = node;
            node = node.next;
            l1 = l1.next;
        }

        // l2剩余未加的位数，直接添加到链表中
        while (l2 != null) {
            int sum = l2.val + node.val;
            node.val = sum % 10;
            node.next = new ListNode(sum / 10);
            last = node;
            node = node.next;
            l2 = l2.next;
        }

        if (node.val == 0) {
            last.next = null;
            node = null;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode res = addTwoNumbers(node1, node4);
        while (res!=null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }

}
