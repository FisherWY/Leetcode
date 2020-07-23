package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/23 16:57
 **/

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 * 示例：
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 * 提示：
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deepest-leaves-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1302 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(), tmp = 0;
            while (size > 0) {
                TreeNode node = queue.poll();
                tmp += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            res = tmp;
        }
        return res;
    }

    private int fun(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftVal = fun(node.left);
        int rightVal = fun(node.right);
        int leftLevel = leftVal >> 16;
        int rightLevel = rightVal >> 16;
        int leftCount = (leftVal << 16) >> 16;
        int rightCount = (rightVal << 16) >> 16;
        if (leftLevel > rightLevel) {
            int level = (leftLevel + 1) << 16;
            return level + leftCount + node.val;
        } else if (leftLevel < rightLevel) {
            int level = (rightLevel + 1) << 16;
            return level + rightCount + node.val;
        } else {
            int level = (leftLevel + 1) << 16;
            return level + Math.max(leftCount, rightCount) + node.val;
        }
    }
}
