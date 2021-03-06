package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<List<Integer>> res;
    private int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.res = new ArrayList<>();
        this.sum = sum;
        fun(root, 0, new ArrayList<>());
        return res;
    }

    private void fun(TreeNode node, int cur, List<Integer> tmp) {
        if (node == null) {
            return;
        }
        cur += node.val;
        tmp.add(node.val);
        if (cur == sum && node.left == null && node.right == null) {
            res.add(tmp);
            return;
        }
        fun(node.left, cur, new ArrayList<>(tmp));
        fun(node.right, cur, new ArrayList<>(tmp));
    }
}
