package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/24 20:01
 **/

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 以 10^9 + 7 为模，返回这些数字之和。
 *
 * 示例：
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * 提示：
 * 树中的结点数介于 1 和 1000 之间。
 * node.val 为 0 或 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1022 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = 0;
    private int mod = 1000000007;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return sum;
        }
        helper(root, 0);
        return sum % mod;
    }

    private void helper(TreeNode node, int cur) {
        cur += node.val;
        if (node.left == null && node.right == null) {
            sum += cur;
        }
        if (node.left != null) {
            helper(node.left, cur * 2);
        }
        if (node.right != null) {
            helper(node.right, cur * 2);
        }
    }
}
