package 剑指Offer;

public class Offer26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (fun(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean fun(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return fun(A.left, B.left) && fun(A.right, B.right);
    }
}
