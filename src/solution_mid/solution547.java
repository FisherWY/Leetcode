package solution_mid;

/**
 * Problem547: 省份数量
 */
public class solution547 {

    private int cityNum;    // 城市数量
    private int[] visit;    // 已经访问过的城市列表
    private int[][] isConnected;    // 无向图

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        this.cityNum = isConnected.length;
        this.visit = new int[cityNum];
        this.isConnected = isConnected;
        for (int i = 0; i < cityNum; i++) {
            if (visit[i] == 0) {    // 如果该城市未访问过,则是一个新的省份
                for (int j = 0; j < cityNum; j++) { // 遍历该城市能到的,并且未访问过的所有城市
                    if (visit[j] == 0 && isConnected[i][j] == 1) {
                        fun(i, j);
                    }
                }
                count++;
            }
        }
        return count;
    }

    private void fun(int last, int cur) {
        if (visit[cur] == 1) {
            return;
        }
        visit[cur] = 1;
        for (int i = 0; i < cityNum; i++) {
            if (isConnected[cur][i] == 1) {
                fun(cur, i);
            }
        }
    }
}
