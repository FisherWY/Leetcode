package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/5 21:11
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution98 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        helper(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        list.add(node.val);
        helper(node.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(20);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        solution98 s = new solution98();
        System.out.println(s.isValidBST(node1));
    }
}
