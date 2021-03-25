package 剑指Offer;

public class Offer68_2 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        fun(root, p, q);
        return res;
    }

    private boolean fun(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean lres = fun(node.left, p, q);
        boolean rres = fun(node.right, p, q);
        if ((lres && rres) || (node.val == p.val || node.val == q.val) && (lres || rres)) {
            res = node;
        }
        return rres || lres || (node.val == p.val || node.val == q.val);
    }
}
