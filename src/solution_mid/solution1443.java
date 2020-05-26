package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/5/26 21:37
 **/

import java.util.List;
import java.util.Map;

/**
 * 给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。
 * 通过树上的一条边，需要花费 1 秒钟。
 * 你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
 * 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。
 * 除此以外，还有一个布尔数组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
 *
 * 示例 1：
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * 输出：8
 * 解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
 *
 * 示例 2：
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * 输出：6
 * 解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
 *
 * 示例 3：
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * 输出：0
 *
 * 提示：
 * 1 <= n <= 10^5
 * edges.length == n-1
 * edges[i].length == 2
 * 0 <= fromi, toi <= n-1
 * fromi < toi
 * hasApple.length == n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-to-collect-all-apples-in-a-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 注：这种解法内存超出限制了，在第53个测试用例时，n=100000，开辟10w大小的二维数组和一维数组估计是小事
 *    问题在于递归调用时，调用栈的开销，保存现场的开销非常大，最终导致内存超限
 *
 * 解决办法：最后用C++语言，加上动态规划解决了，C++内存占用达到了50+MB，想想都觉得nb
 */
public class solution1443 {

    private int res = 0;
    private int[] visited;
    private int[][] edges;
    private List<Boolean> hasApple;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        this.visited = new int[n];
        this.edges = new int[n][n];
        for (int[] edge : edges) {
            this.edges[edge[0]][edge[1]] = 1;
            this.edges[edge[1]][edge[0]] = 1;
        }
        visited[0] = 1;
        for (int i = 0; i < n; i++) {
            if (this.edges[0][i] == 1) {
                fun(0, i);
            }
        }
        return res;
    }

    private boolean fun(int from, int cur) {
        visited[cur] = 1;
        boolean find = false;
        if (hasApple.get(cur)) {
            find = true;
        }
        for (int i = 0; i < edges[cur].length; i++) {
            if (visited[i] == 0 && edges[cur][i] == 1) {
                find |= fun(cur, i);
            }
        }
        if (find) {
            res += 2;
        }
        return find;
    }
}
