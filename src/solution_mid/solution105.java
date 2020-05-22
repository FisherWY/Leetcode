package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/5/22 21:43
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // K：节点值 V：节点对应在中序遍历中的下标
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        // 前序的第一个节点就是该子树的根节点
        TreeNode node = new TreeNode(preorder[pre_left]);
        // 寻找该节点在中序遍历的位置，以区分左右子树
        int pos = map.get(node.val);
        // 左子树节点数量
        int leftCount = pos - in_left;
        // 建立左子树
        node.left = build(preorder, inorder, pre_left + 1, pre_left + leftCount, in_left, pos - 1);
        // 建立右子树
        node.right = build(preorder, inorder, pre_left + leftCount + 1, pre_right, pos + 1, in_right);
        return node;
    }
}
