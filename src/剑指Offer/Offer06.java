package 剑指Offer;

import java.util.Stack;

/**
 * 剑指Offer06: 从尾到头打印链表
 */
public class Offer06 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int pos = 0;
        while (!stack.empty()) {
            res[pos] = stack.pop();
            pos++;
        }
        return res;
    }
}
