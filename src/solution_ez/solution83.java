package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/9 22:49
 **/

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class solution83 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode pointer = head;
        ListNode worker = head.next;
        while (worker != null) {
            if (pointer.val == worker.val) {
                pointer.next = worker.next;
            } else {
                pointer = pointer.next;
            }
            worker = worker.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Test Data
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // Solution
        solution83 s = new solution83();
        ListNode res = s.deleteDuplicates(node0);
        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }
}
