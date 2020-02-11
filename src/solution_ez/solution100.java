package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/11 21:53
 **/

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
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

/**
 * 不知道为什么我的代码放到leetcode中，同样的输入下，控制台下的代码执行是正确的，提交后是错误的
 */
public class solution100 {

    private static StringBuilder s1 = new StringBuilder();
    private static StringBuilder s2 = new StringBuilder();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        fun(p, s1);
        fun(q, s2);
        String ss1 = s1.toString();
        String ss2 = s2.toString();
        return ss1.equals(ss2);
    }

    private void fun(TreeNode node, StringBuilder s) {
        if (node == null) {
            s.append('n');
        } else {
            // 左子树
            fun(node.left, s);
            // 添加到String中
            s.append(node.val);
            // 右子树
            fun(node.right, s);
        }
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        l1.left = l2;
        l1.right = l3;

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(2);
        r1.left = r2;
        r1.right = r3;

        solution100 s = new solution100();
        if (s.isSameTree(null, null)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
