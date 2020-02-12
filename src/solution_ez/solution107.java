package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/12 22:34
 **/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
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
public class solution107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Queue<TreeNode>> queue = new LinkedList<>();
        if (root == null) {
            return res;
        } else {
            Queue<TreeNode> queue_tmp = new LinkedList<>();
            queue_tmp.offer(root);
            queue.offer(queue_tmp);
        }
        while (!queue.isEmpty()) {
            // 将本层节点取出，顺便添加其子节点
            Queue<TreeNode> queue_tmp = queue.poll();
            Queue<TreeNode> queue_next = new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            while (!queue_tmp.isEmpty()) {
                TreeNode node = queue_tmp.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue_next.offer(node.left);
                }
                if (node.right != null) {
                    queue_next.offer(node.right);
                }
            }
            res.add(list);
            if (!queue_next.isEmpty()) {
                queue.offer(queue_next);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
