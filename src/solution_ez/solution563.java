package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/16 22:10
 **/

/**
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 示例:
 * 输入:
 *          1
 *        /   \
 *       2     3
 * 输出: 1
 *
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *
 * 注意:
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution563 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = 0;

    public int findTilt(TreeNode root) {
        fun(root);
        return sum;
    }

    private int fun(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = fun(node.left);
        int right = fun(node.right);
        sum += Math.abs(left - right);
        return node.val + left + right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        solution563 s = new solution563();
        System.out.println(s.findTilt(node1));
    }
}
