package 剑指Offer;

public class Offer25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), ptr = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if (l1 != null) {
            ptr.next = l1;
        }
        if (l2 != null) {
            ptr.next = l2;
        }
        return head.next;
    }
}
