package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class Offer07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        // 建立完成
        if (preLeft > preRight) {
            return null;
        }
        // 前序遍历的第一个节点即为当前位置的根节点
        TreeNode node = new TreeNode(preorder[preLeft]);
        // 当前节点在中序遍历中的位置
        int pos = map.get(preorder[preLeft]);
        // 计算当前节点左子树中还有多少个节点
        int leftCount = pos - inLeft;
        // 建立左右子树
        node.left = build(preorder, inorder, preLeft + 1, preLeft + leftCount, inLeft, pos - 1);
        node.right = build(preorder, inorder, preLeft + leftCount + 1, preRight, pos + 1, inRight);
        return node;
    }
}
