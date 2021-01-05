package 剑指Offer;

/**
 * 线性查找的方法就好，但是要从右上角开始查找。
 * 从右上角开始查找能够排除掉一整行
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int x = 0, y = matrix[0].length - 1;
        while (x < row && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if(matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
