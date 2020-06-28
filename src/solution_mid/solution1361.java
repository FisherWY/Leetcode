package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/28 17:07
 **/

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 *
 * 示例 1：
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * 输出：true
 *
 * 示例 2：
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * 输出：false
 *
 * 示例 3：
 * 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * 输出：false
 *
 * 示例 4：
 * 输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 * 输出：false
 *
 * 提示：
 * 1 <= n <= 10^4
 * leftChild.length == rightChild.length == n
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1361 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 记录入度
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                in[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                in[rightChild[i]]++;
            }
        }
        // 寻找根节点
        int rootIndex = -1;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) {
            return false;
        }
        // 层序遍历
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        set.add(rootIndex);
        queue.offer(rootIndex);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (leftChild[node] != -1) {
                // 已经遍历过的节点
                if (set.contains(leftChild[node])) {
                    return false;
                }
                set.add(leftChild[node]);
                queue.offer(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                if (set.contains(rightChild[node])) {
                    return false;
                }
                set.add(rightChild[node]);
                queue.offer(rightChild[node]);
            }
        }
        return set.size() == n;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1,-1,3,-1}, rightChild = {2,3,-1,-1};
        solution1361 s = new solution1361();
        System.out.println(s.validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}
