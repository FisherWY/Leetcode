package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/24 22:24
 **/

import java.util.Arrays;

/**
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 * 示例：
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *  
 * 提示：
 * 1 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= costs[i][0], costs[i][1] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1029 {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,((o1, o2) -> {
            int res1 = o1[0] - o1[1];
            int res2 = o2[0] - o2[1];
            return res1 - res2;
        }));
        int sum = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][0];
            sum += costs[costs.length - i - 1][1];
        }
        return sum;
    }

    public static void main(String[] args) {
        solution1029 s = new solution1029();
        int[][] costs = {
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        };
        System.out.println(s.twoCitySchedCost(costs));
    }
}
