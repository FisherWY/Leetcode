package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class Offer35 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();  // 旧节点到新节点的映射：旧节点 -> 新节点
        Node flag = new Node(-1), ptr = flag;
        while (head != null) {
            Node node = new Node(head.val);
            ptr.next = node;
            map.put(head, node);
            head = head.next;
            ptr = ptr.next;
        }
        for (Node node : map.keySet()) {
            map.get(node).random = map.get(node.random);
        }
        return flag.next;
    }


    private class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
