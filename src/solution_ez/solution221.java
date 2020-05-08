package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/8 21:44
 **/

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] arr = new int[matrix.length][matrix[0].length];
        int res = 0;
        // 动态规划
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 边界填充
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]) + 1;
                    }
                    res = Math.max(res, arr[i][j]);
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {

    }
}
