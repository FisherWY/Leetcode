package 剑指Offer;

public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return fun(postorder, 0, postorder.length - 1);
    }

    private boolean fun(int[] arr, int i, int j) {  // 后序遍历，i为左子树起始位置，j为根节点
        if (i >= j) {
            return true;
        }
        int m = i;
        while (arr[m] < arr[j]) {   // 寻找左子树的根节点，左子树的值均小于根节点的值
            m++;
        }
        int n = m;
        while (arr[n] > arr[j]) {   // 验证右子树的值是否均大于根节点的值
            n++;
        }
        return n == j && fun(arr, i, m - 1) && fun(arr, m, j - 1);
    }
}
