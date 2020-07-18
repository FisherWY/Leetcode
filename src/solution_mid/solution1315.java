package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/17 18:37
 **/

/**
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 * 示例：
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *
 * 提示：
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1315 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum;

    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        fun(root, null, null);
        return sum;
    }

    private void fun(TreeNode node, TreeNode parent, TreeNode grandparent) {
        if (node == null) {
            return;
        }
        if (grandparent != null && grandparent.val % 2 == 0) {
            sum += node.val;
        }
        fun(node.left, node, parent);
        fun(node.right, node, parent);
    }
}
