package solution_mid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem399: 除法求值
 */
public class solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationSize);
        // 预处理，将变量的值与ID进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> map = new HashMap<>(2 * equationSize);
        int id = 0;
        for (int i = 0; i < equationSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }
        // 做查询
        int queriesSize = queries.size();
        double[] answer = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);

            if (id1 == null || id2 == null) {   // 变量不存在，直接得出结果-1
                answer[i] = -1.0d;
            } else {
                answer[i] = unionFind.isConnected(id1, id2);
            }
        }

        return answer;
    }

    private class UnionFind {

        private int[] parent;
        // 指向父节点的权值
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        /**
         * 建立从 Y 到 X 的权值关系
         * @param x
         * @param y
         * @param value
         */
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // 将树的高度化为 2 的关键
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩，寻找节点 X 的根节点。同时，一边寻找一边重新整理树的结构
         * @param x
         * @return 根节点的ID
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {   // 如果两个节点有相同的根节点，表明他们之间存在关联，直接计算得出结果
                return weight[x] / weight[y];
            } else {    // 没有关联，返回-1
                return -1.0d;
            }
        }
    }
}
