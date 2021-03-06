package 剑指Offer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Offer36 {

    private Queue<Node> queue;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        queue = new ArrayDeque<>();
        func(root);
        Node head = queue.peek(), ptr = head;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            ptr.right = tmp;
            tmp.left = ptr;
            ptr = tmp;
        }
        ptr.right = head;
        head.left = ptr;
        return head;
    }

    private void func(Node cur) {
        if (cur == null) {
            return;
        }
        func(cur.left);
        queue.offer(cur);
        func(cur.right);
    }

    // 更优解
    private Node head, prev;
    public Node treeToDoubleList(Node root) {
        if (root == null) {
            return null;
        }
        func1(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void func1(Node cur) {
        if (cur == null) {
            return;
        }
        func1(cur.left);
        if (prev != null) {
            prev.right = cur;
        } else {
            head = cur;
        }
        cur.left = prev;
        prev = cur;
        func1(cur.right);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
