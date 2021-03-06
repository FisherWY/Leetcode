package solution21_30;

/**
 * @Author Fisher
 * @Date 2019/8/1 11:22
 **/

import java.util.Stack;

/**
 * Question25：K个一组翻转列表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution25 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        // 哨兵节点
        ListNode res = new ListNode(0);
        // 工作指针
        ListNode ptr = res;
        while (true) {
            int count = 0;
            // tmp最终指向下一次开始翻转的头部
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.push(tmp);
                tmp = tmp.next;
                count++;
            }
            // 到达链表尾部，不足以达到翻转数目，直接接上尾部
            if (count != k) {
                ptr.next = head;
                break;
            }
            while (!stack.empty()) {
                ptr.next = stack.pop();
                ptr = ptr.next;
            }
            // ptr.next = tmp;
            // 指向下一次开始翻转的头部
            head = tmp;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        for (int i=0; i<5; i++) {
            ListNode node = new ListNode(i+1);
            ptr.next = node;
            ptr = node;
        }
        int k = 2;

        solution25 s25 = new solution25();
        ListNode list = s25.reverseKGroup(head.next, k);
        while (list != null) {
            System.out.print(list.val + " -> ");
            list = list.next;
        }

    }
}
