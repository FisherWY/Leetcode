package 剑指Offer;

public class Offer18 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode deleteNode(ListNode head, int val) {
        ListNode ptr = new ListNode(-1);
        ptr.next = head;
        ListNode prev = ptr;
        while(head != null) {
            if (head.val == val) {
                prev.next = head.next;
                break;
            }
            prev = head;
            head = head.next;
        }
        return ptr.next;
    }
}
