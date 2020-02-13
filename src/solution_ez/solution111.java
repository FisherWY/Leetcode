package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/13 22:11
 **/

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class solution111 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        // 对于根节点为空的处理
        if (root == null) {
            return 0;
        }

        // 对于只有一个根节点的处理
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 正常二叉树处理
        int depth = Integer.MAX_VALUE;
        if (root.left != null) {
            depth = Math.min(minDepth(root.left), depth);
        }
        if (root.right != null) {
            depth = Math.min(minDepth(root.right), depth);
        }
        return depth + 1;
    }

}
