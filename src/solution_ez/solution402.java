package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/3 21:59
 **/

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution402 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        fun(root);
        return sum;
    }

    private void fun(TreeNode node) {
        // 空指针
        if (node == null) {
            return;
        }
        // 存在左节点，且左节点为叶子节点
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
        }
        // 递归
        fun(node.left);
        fun(node.right);
    }
}
