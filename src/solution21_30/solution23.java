package solution21_30;

/**
 * @Author Fisher
 * @Date 2019/7/30 10:28
 **/

import java.util.List;

/**
 * Question23：合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution23 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 0) {
            return null;
        }
        return fun(lists, 0, lists.length - 1);
    }

    private ListNode fun(ListNode[] lists, int left, int right) {
        ListNode l1;
        ListNode l2;

        // 分到最小情况
        if (left == right) {
            return lists[left];
        } else {
            int mid = (left + right) / 2;
            // 左边区域划分
            l1 = fun(lists, left, mid);
            // 右边区域划分
            l2 = fun(lists, mid+1, right);
        }

        // 合并2条链表
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        // 拼接剩下的链表
        if (l1 == null) {
            res.next = l2;
        } else {
            res.next = l1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        ListNode[] list = {node1, node4, node7};

        solution23 s23 = new solution23();
        ListNode res = s23.mergeKLists(list);
        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }
}
