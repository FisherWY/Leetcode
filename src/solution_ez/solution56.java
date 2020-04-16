package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/16 21:41
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] x : intervals) {
            boolean flag = true;
            for (int[] item : res) {
                // 在内部
                if (x[0] >= item[0] && x[1] <= item[1]) {
                    flag = false;
                    break;
                }
                // 包含item
                if (x[0] <= item[0] && x[1] >= item[1]) {
                    item[0] = x[0];
                    item[1] = x[1];
                    flag = false;
                    break;
                }
                // 左范围扩充
                if (x[1] >= item[0] && x[0] < item[0]) {
                    item[0] = x[0];
                    flag = false;
                    break;
                }
                // 右范围扩充
                if (x[0] <= item[1] && x[1] > item[1]) {
                    item[1] = x[1];
                    flag = false;
                    break;
                }
                // 新区间
                flag = true;
            }
            if (flag) {
                res.add(x);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{1,10}};
        solution56 s = new solution56();
        int[][] res = s.merge(intervals);
        for (int[] row : res) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
