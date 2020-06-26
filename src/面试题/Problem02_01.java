package 面试题;

/**
 * @Author Fisher
 * @Date 2020/6/26 18:05
 **/

import solution_mid.solution1367;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 *
 * 示例2:
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * 提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 *
 * 进阶：
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem02_01 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode ptr = head, prev = null;
        while (ptr != null) {
            if (set.contains(ptr.val)) {
                prev.next = ptr.next;
            } else {
                set.add(ptr.val);
                prev = ptr;
            }
            ptr = ptr.next;
        }
        return head;
    }
}
