package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/8/2 16:34
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<TreeNode> list = null;

    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        fun(root);
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.right = list.get(i + 1);
            node.left = null;
        }
    }

    private void fun(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node);
        fun(node.left);
        fun(node.right);
    }
}
