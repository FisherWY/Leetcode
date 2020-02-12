package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/12 23:38
 **/

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
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
public class solution110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        // 空的节点树一定是平衡的
        if (root == null) {
            return true;
        } else {
            // 计算当前子树的左右子树高度差
            int left_height = height(root.left);
            int right_height = height(root.right);
            return Math.abs(left_height - right_height) < 2 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int height(TreeNode node) {
        // 当前节点为空时，高度是-1
        if (node == null) {
            return -1;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }
}
