package 剑指Offer;

public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return new int[0];
        }
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        int pos = 0;
        while (left <= right && top <= bottom) {
            // from left to right
            for (int i = left; i <= right; i++) {
                res[pos++] = matrix[top][i];
            }
            // from top to bottom
            for (int i = top + 1; i <= bottom; i++) {
                res[pos++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                // from right to left
                for (int i = right - 1; i > left; i--) {
                    res[pos++] = matrix[bottom][i];
                }
                // from bottom to top
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
        Offer29 offer29 = new Offer29();
        int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int[] res = offer29.spiralOrder(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
