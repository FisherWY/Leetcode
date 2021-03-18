package 剑指Offer;

public class Offer52 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) {
            if (ptrA == null) {
                ptrA = headB;
                continue;
            }
            if (ptrB == null) {
                ptrB = headA;
                continue;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return ptrA;
    }
}
