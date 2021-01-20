package 剑指Offer;

/**
 * 剑指Offer12：矩阵中的路径
 */
public class Offer12 {

    private String word;
    private char[][] board;
    private int[][] visited;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        this.visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (fun("", i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean fun(String cur, int posX, int posY, int step) {
        if (board[posX][posY] != word.charAt(step)) {
            return false;
        }
        // 添加当前位置的字母
        cur += board[posX][posY];
        // 修改visited状态
        visited[posX][posY] = 1;
        System.out.println(cur);
        // 递归结束
        if (cur.length() == word.length()) {
            return word.equals(cur);
        }
        // 往左走
        if (posY > 0 && visited[posX][posY - 1] == 0) {
            if (fun(cur, posX, posY - 1, step + 1)) {
                return true;
            }
        }
        // 往右走
        if (posY < board[posX].length - 1 && visited[posX][posY + 1] == 0) {
            if (fun(cur, posX, posY + 1, step + 1)) {
                return true;
            }
        }
        // 往上
        if (posX > 0 && visited[posX - 1][posY] == 0) {
            if (fun(cur, posX - 1, posY, step + 1)) {
                return true;
            }
        }
        // 往下
        if (posX < board.length - 1 && visited[posX + 1][posY] == 0) {
            if (fun(cur, posX + 1, posY, step + 1)) {
                return true;
            }
        }
        // 上下左右走都没找到，回溯
        visited[posX][posY] = 0;
        return false;
    }
}
