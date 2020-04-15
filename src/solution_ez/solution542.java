package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/15 22:59
 **/

import java.util.Arrays;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 示例 2:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * 注意:
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution542 {

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        // 填充较大的数
        for (int[] x : dp) {
            Arrays.fill(x, Integer.MAX_VALUE / 2);
        }
        // 先将零填充到dp中
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        // 从左上角往右下角搜索左边和上边
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 上边
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                // 左边
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右上角往左下角搜索右边和上边
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                // 上边
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                // 右边
                if (j + 1 < col) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        // 从左下角往右上角搜索左边和下边
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                // 下边
                if (i + 1 < row) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                // 左边
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右下角往左上角搜索右边和下边
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                // 下边
                if (i + 1 < row) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                // 右边
                if (j + 1 < col) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
