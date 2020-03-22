package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/22 22:36
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution653 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        fun(root);
        for (int x : set) {
            if (k - x != x && set.contains(k - x)) {
                return true;
            }
        }
        return false;
    }

    private void fun(TreeNode node) {
        if (node == null) {
            return;
        }
        fun(node.left);
        set.add(node.val);
        fun(node.right);
    }
}
