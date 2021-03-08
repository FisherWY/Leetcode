package 剑指Offer;

import java.util.LinkedList;
import java.util.Queue;

public class Offer37 {
    
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder builder = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    builder.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    builder.append("null");
                }
                builder.append(',');
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(']');
            return builder.toString();
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) {
                return null;
            }
            String[] arr = data.substring(1, data.length() - 1).split(",");
            TreeNode head = new TreeNode(Integer.parseInt(arr[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(head);
            int pos = 1;
            while (!queue.isEmpty() && pos < arr.length) {
                TreeNode node = queue.poll();
                if (!"null".equals(arr[pos])) {
                    node.left = new TreeNode(Integer.parseInt(arr[pos]));
                    queue.offer(node.left);
                }
                pos++;
                if (!"null".equals(arr[pos])) {
                    node.right = new TreeNode(Integer.parseInt(arr[pos]));
                    queue.offer(node.right);
                }
                pos++;
            }
            return head;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public Codec getCodec() {
        return new Codec();
    }

    public static void main(String[] args) {
        String str = "[1,2,3,null,null,4,5]";
        Offer37 offer37 = new Offer37();
        Offer37.Codec codec = offer37.getCodec();
        TreeNode head = codec.deserialize(str);
        String res = codec.serialize(head);
        System.out.println(res);
    }

}
