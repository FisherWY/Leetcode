package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/14 22:59
 **/

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution445 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 压栈
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode ptr1 = l1, ptr2 = l2;
        while (ptr1 != null) {
            stack1.push(ptr1);
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            stack2.push(ptr2);
            ptr2 = ptr2.next;
        }
        boolean res = stack1.size() > stack2.size();
        // 两栈相加
        boolean flag = false;
        while (!stack1.empty() && !stack2.empty()) {
            int tmp = stack1.peek().val + stack2.peek().val;
            if (flag) {
                tmp++;
            }
            stack1.pop().val = tmp % 10;
            stack2.pop().val = tmp % 10;
            if (tmp / 10 > 0) {
                flag = true;
            } else {
                flag = false;
            }
        }
        // 有余进位
        while (flag) {
            if (!stack1.empty()) {
                int tmp = stack1.peek().val + 1;
                stack1.pop().val = tmp % 10;
                if (tmp / 10 > 0) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            } else if (!stack2.empty()) {
                int tmp = stack2.peek().val + 1;
                stack2.pop().val = tmp % 10;
                if (tmp / 10 > 0) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            } else {
                break;
            }
        }
        // 最高位进位
        if (flag) {
            ListNode node = new ListNode(1);
            node.next = (res ? l1 : l2);
            return node;
        } else {
            return res ? l1 : l2;
        }
    }

}
