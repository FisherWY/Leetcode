package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/12 21:16
 **/

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 *
 * 示例 1：
 * 输入：[[2]]
 * 输出：10
 *
 * 示例 2：
 * 输入：[[1,2],[3,4]]
 * 输出：34
 *
 * 示例 3：
 * 输入：[[1,0],[0,2]]
 * 输出：16
 *
 * 示例 4：
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 *
 * 示例 5：
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 * 提示：
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution892 {

    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int N = grid.length;
        int res = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] > 0) {
                    res += 2;
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                            nv = grid[nr][nc];
                        }
                        res += Math.max(grid[r][c] - nv, 0);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{2}};
        solution892 s = new solution892();
        System.out.println(s.surfaceArea(grid));
    }
}
