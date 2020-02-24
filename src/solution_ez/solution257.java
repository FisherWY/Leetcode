package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/24 21:11
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        fun(root, "");
        return list;
    }

    private void fun(TreeNode node, String s) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            s += node.val;
            list.add(s);
            return;
        }
        s += node.val + "->";
        fun(node.left, s);
        fun(node.right, s);
    }
}
