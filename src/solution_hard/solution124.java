package solution_hard;

/**
 * @Author Fisher
 * @Date 2020/6/21 21:11
 **/

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *        1
 *       / \
 *      2   3
 * 输出: 6
 *
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution124 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        fun(root);
        return sum;
    }

    private int fun(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(fun(node.left), 0);
        int right = Math.max(fun(node.right), 0);
        int cur = node.val + left + right;
        sum = Math.max(sum, cur);
        return node.val + Math.max(left, right);
    }

}
