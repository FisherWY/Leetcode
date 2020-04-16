package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/16 22:36
 **/

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 *
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 *
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *
 * 提示：
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution938 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int res = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return res;
    }

    private void helper(TreeNode node, int L, int R) {
        if (node == null) {
            return;
        }
        if (node.val >= L && node.val <= R) {
            res += node.val;
        }
        if (node.val >= L) {
            helper(node.left, L, R);
        }
        if (node.val <= R) {
            helper(node.right, L, R);
        }
    }
}
