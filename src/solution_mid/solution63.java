package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/6 17:01
 **/

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < col && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    // 超时方法
    private int[][] map;
    private int count = 0, mapRow, mapCol;

    public int myUniquePathsWithObstacles(int[][] obstacleGrid) {
        this.map = obstacleGrid;
        this.mapRow = obstacleGrid.length;
        this.mapCol = obstacleGrid[0].length;
        fun(0, 0);
        return count;
    }

    private void fun(int row, int col) {
        // 当前点是障碍
        if (map[row][col] == 1) {
            return;
        }
        // 到达终点
        if (row == mapRow - 1 && col == mapCol - 1) {
            count++;
            return;
        }
        // 向右走
        if (col + 1 < mapCol) {
            fun(row, col + 1);
        }
        // 向下走
        if (row + 1 < mapRow) {
            fun(row + 1, col);
        }
    }

    public static void main(String[] args) {
        int[][] data = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        solution63 s = new solution63();
        System.out.println(s.uniquePathsWithObstacles(data));
    }
}
