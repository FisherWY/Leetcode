package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class Offer54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthLargest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        fun(list, root);
        return list.get(k - 1).val;
    }

    private void fun(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }
        fun(list, node.right);
        list.add(node);
        fun(list, node.left);
    }
}