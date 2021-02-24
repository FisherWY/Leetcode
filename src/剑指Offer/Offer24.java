package 剑指Offer;

public class Offer24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = null, next = null;
        while (head.next != null) {
            next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        head.next = last;
        return head;
    }
}
