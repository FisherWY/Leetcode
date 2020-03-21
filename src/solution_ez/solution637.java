package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/21 21:47
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 *
 * 注意：
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution637 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode get(TreeNode root) {
        TreeNode node = new TreeNode(0);
        node.left = root;
        node.right = root;
        return node;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        double avg = 0.0;
        queue.add(root);
        queue.add(get(root));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == root && node.right == root) {
                if (queue.size() != 0) {
                    queue.add(get(root));
                }
                list.add(avg / count);
                avg = 0.0;
                count = 0;
            } else {
                avg += node.val;
                count++;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        solution637 s = new solution637();
        s.averageOfLevels(node1);
    }
}
