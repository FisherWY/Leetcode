package 面试题;

/**
 * @Author Fisher
 * @Date 2020/6/5 17:04
 **/

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int pos = 0;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 从左往右
            for (int i = left; i <= right; i++) {
                res[pos++] = matrix[top][i];
            }
            // 从上往下
            for (int i = top + 1; i <= bottom; i++) {
                res[pos++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                // 从右往左
                for (int i = right - 1; i > left; i--) {
                    res[pos++] = matrix[bottom][i];
                }
                //从下往上
                for (int i = bottom; i > top; i--) {
                    res[pos++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Problem29 p = new Problem29();
        for (int x : p.spiralOrder(matrix)) {
            System.out.print(x + " ");
        }
    }
}
