package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/8/5 15:57
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 提示：
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution207 {
    private List<List<Integer>> lists;
    private int[] visited;
    private boolean flag = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        lists = new ArrayList<>(numCourses);
        for (int i =0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] arr : prerequisites) {
            lists.get(arr[1]).add(arr[0]);
        }
        for (int i = 0; i < numCourses && flag; i++) {
            if (visited[i] == 0) {
                fun(i);
            }
        }
        return flag;
    }

    private void fun(int n) {
        visited[n] = 1;
        for (int x : lists.get(n)) {
            if (visited[x] == 0) {
                fun(x);
                if (!flag) {
                    return;
                }
            } else if (visited[x] == 1) {
                flag = false;
                return;
            }
        }
        visited[n] = 2;
    }
}
