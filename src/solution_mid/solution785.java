package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/16 19:24
 **/

import java.util.Arrays;

/**
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。
 * 这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 *
 * 注意:
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution785 {

    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] colorBoard;
    private boolean res = true;

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        res = true;
        colorBoard = new int[len];
        Arrays.fill(colorBoard, UNCOLORED);
        for (int i = 0; i < len && res; i++) {
            if (colorBoard[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return res;
    }

    private void dfs(int node, int color, int[][] graph) {
        colorBoard[node] = color;
        int nextColor = (color == RED ? GREEN : RED);
        for (int neighbour : graph[node]) { // 寻找与该节点连通的其他节点
            if (colorBoard[neighbour] == UNCOLORED) {   // 其他节点未上色
                dfs(neighbour, nextColor, graph);
                if (!res) {
                    return;
                }
            } else if (colorBoard[neighbour] != nextColor){ // 已上色，但颜色与当前节点一致
                res = false;
                return;
            }
        }
    }
}
