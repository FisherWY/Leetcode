package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/15 21:54
 **/

/**
 * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
 * 1 表示连接左单元格和右单元格的街道。
 * 2 表示连接上单元格和下单元格的街道。
 * 3 表示连接左单元格和下单元格的街道。
 * 4 表示连接右单元格和下单元格的街道。
 * 5 表示连接左单元格和上单元格的街道。
 * 6 表示连接右单元格和上单元格的街道。
 * 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
 * 注意：你 不能 变更街道。
 * 如果网格中存在有效的路径，则返回 true，否则返回 false 。
 *
 * 示例 1：
 * 输入：grid = [[2,4,3],[6,5,2]]
 * 输出：true
 * 解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
 *
 * 示例 2：
 * 输入：grid = [[1,2,1],[1,2,1]]
 * 输出：false
 * 解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
 *
 * 示例 3：
 * 输入：grid = [[1,1,2]]
 * 输出：false
 * 解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
 *
 * 示例 4：
 * 输入：grid = [[1,1,1,1,1,1,3]]
 * 输出：true
 *
 * 示例 5：
 * 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
 * 输出：true
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * 1 <= grid[i][j] <= 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1391 {

    private int[][] map = null;

    public boolean hasValidPath(int[][] grid) {
        // 映射到更高维度的地图上
        buildMap(grid);
        dfs(map, 1, 1);
        return map[map.length - 2][map[0].length - 2] == 0;
    }

    private void dfs(int[][] map, int posX, int posY) {
        map[posX][posY] = 0;    // 标志本街区去过了
        // 往上走
        if (map[posX - 1][posY] == 1 && posX - 3 >= 0) {    // 能往上走
            if (map[posX - 2][posY] == 1 && map[posX - 3][posY] == 1) { // 上方街区有入口，且没去过
                dfs(map, posX - 3, posY);
            }
        }
        // 往下走
        if (map[posX + 1][posY] == 1 && posX + 3 < map.length) {    // 能往下走
            if (map[posX + 2][posY] == 1 && map[posX + 3][posY] == 1) { // 下方街区有入口，且没去过
                dfs(map, posX + 3, posY);
            }
        }
        // 往左走
        if (map[posX][posY - 1] == 1 && posY - 3 >= 0) {    // 能往左走
            if (map[posX][posY - 2] == 1 && map[posX][posY - 3] == 1) { // 左方街区有入口，且没去过
                dfs(map, posX, posY - 3);
            }
        }
        // 往右走
        if (map[posX][posY + 1] == 1 && posY + 3 < map[posX].length) {    // 能往左走
            if (map[posX][posY + 2] == 1 && map[posX][posY + 3] == 1) { // 左方街区有入口，且没去过
                dfs(map, posX, posY + 3);
            }
        }
    }

    private void buildMap(int[][] grid) {
        map = new int[grid.length * 3][grid[0].length * 3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int newPosX = 3 * i + 1;
                int newPosY = 3 * j + 1;
                map[newPosX][newPosY] = 1;
                switch (grid[i][j]) {
                    case 1: // 左右连通
                        map[newPosX][newPosY - 1] = map[newPosX][newPosY + 1] = 1;
                        break;
                    case 2: // 上下连通
                        map[newPosX - 1][newPosY] = map[newPosX + 1][newPosY] = 1;
                        break;
                    case 3: // 左下连通
                        map[newPosX][newPosY - 1] = map[newPosX + 1][newPosY] = 1;
                        break;
                    case 4: // 右下连通
                        map[newPosX][newPosY + 1] = map[newPosX + 1][newPosY] = 1;
                        break;
                    case 5: // 左上连通
                        map[newPosX][newPosY - 1] = map[newPosX - 1][newPosY] = 1;
                        break;
                    case 6: // 右上连通
                        map[newPosX][newPosY + 1] = map[newPosX - 1][newPosY] = 1;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
