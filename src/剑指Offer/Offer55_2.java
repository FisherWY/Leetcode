package 剑指Offer;


public class Offer55_2 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean flag;

    public boolean isBalanced(TreeNode root) {
        flag = true;
        fun(root, 1);
        return flag;
    }

    private int fun(TreeNode node, int cur) {
        if (node == null) {
            return cur;
        }
        int left = fun(node.left, cur + 1);
        int right = fun(node.right, cur + 1);
        if (Math.abs(right - left) > 1) {
            flag = false;
        }
        return Math.max(left, right);
    }
}
