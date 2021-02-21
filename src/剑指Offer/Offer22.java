package 剑指Offer;

public class Offer22 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode ptr = head;
        while (ptr != null && k > 0) {
            ptr = ptr.next;
            k--;
        }
        while (ptr != null) {
            head = head.next;
            ptr = ptr.next;
        }
        return head;
    }
}