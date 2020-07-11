package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/11 22:43
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。
 *
 * 示例 1：
 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 *
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-the-matrix-diagonally
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1329 {

    public int[][] diagonalSort(int[][] mat) {
        int rowLen = mat.length, colLen = mat[0].length;
        List<Integer> list = new ArrayList<>();
        // 每一列
        for (int i = 0; i < colLen; i++) {
            int row = 0, col = i;
            while (row < rowLen && col < colLen) {
                list.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            int pos = list.size();
            while (row > 0 && col > 0) {
                mat[--row][--col] = list.get(--pos);
            }
            list.clear();
        }
        // 除第一行外的每一行
        for (int i = 1; i < rowLen; i++) {
            int row = i, col = 0;
            while (row < rowLen && col < colLen) {
                list.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            int pos = list.size();
            while (row > 0 && col > 0) {
                mat[--row][--col] = list.get(--pos);
            }
            list.clear();
        }
        return mat;
    }
}
