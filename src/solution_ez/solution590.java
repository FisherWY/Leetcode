package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/18 22:01
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class solution590 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        fun(root);
        return res;
    }

    private void fun(Node node) {
        if (node == null) {
            return;
        }
        for (Node x : node.children) {
            fun(x);
        }
        res.add(node.val);
    }
}
