package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/22 16:20
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 * 示例 1：
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 *
 * 示例 2：
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 *
 * 示例 3：
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 *
 * 示例 4：
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 *
 * 示例 5：
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *
 * 提示：
 * 每棵树最多有 5000 个节点。
 * 每个节点的值在 [-10^5, 10^5] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1305 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        fun(root1, list1);
        fun(root2, list2);
        List<Integer> res = new ArrayList<>(list1.size() + list2.size());
        int pos1 = 0, pos2 = 0;
        while (pos1 < list1.size() && pos2 < list2.size()) {
            if (list1.get(pos1) < list2.get(pos2)) {
                res.add(list1.get(pos1));
                pos1++;
            } else {
                res.add(list2.get(pos2));
                pos2++;
            }
        }
        while (pos1 < list1.size()) {
            res.add(list1.get(pos1++));
        }
        while (pos2 < list2.size()) {
            res.add(list2.get(pos2++));
        }
        return res;
    }

    private void fun(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        fun(node.left, list);
        list.add(node.val);
        fun(node.right, list);
    }
}
