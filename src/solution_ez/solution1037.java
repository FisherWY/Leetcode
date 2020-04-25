package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/25 22:57
 **/

/**
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 *
 * 示例 1：
 * 输入：[[1,1],[2,3],[3,2]]
 * 输出：true
 *
 * 示例 2：
 * 输入：[[1,1],[2,2],[3,3]]
 * 输出：false
 *  
 * 提示：
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-boomerang
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1037 {

    /**
     * 计算线AB与线AC的斜率是否相等
     * k1 = (y1 - y2) / (x1 - x2)
     * k2 = (y1 - y3) / (x1 - x3)
     **/
    public boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }

    public static void main(String[] args) {
        solution1037 s = new solution1037();
        int[][] points = {
                {1,1},
                {2,2},
                {3,3}
        };
        System.out.println(s.isBoomerang(points));
    }
}
