package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/11 21:43
 **/

/**
 * 给你一个以 (radius, x_center, y_center) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2)，其中 (x1, y1) 是矩形左下角的坐标，(x2, y2) 是右上角的坐标。
 * 如果圆和矩形有重叠的部分，请你返回 True ，否则返回 False 。
 * 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
 *
 * 示例 1：
 * 输入：radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * 输出：true
 * 解释：圆和矩形有公共点 (1,0)
 *
 * 示例 2：
 * 输入：radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
 * 输出：true
 *
 * 示例 3：
 * 输入：radius = 1, x_center = 1, y_center = 1, x1 = -3, y1 = -3, x2 = 3, y2 = 3
 * 输出：true
 *
 * 示例 4：
 * 输入：radius = 1, x_center = 1, y_center = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
 * 输出：false
 *
 * 提示：
 * 1 <= radius <= 2000
 * -10^4 <= x_center, y_center, x1, y1, x2, y2 <= 10^4
 * x1 < x2
 * y1 < y2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circle-and-rectangle-overlapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1401 {

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        double x0 = (x1 + x2) / 2.0;
        double y0 = (y1 + y2) / 2.0;

        double[] p = {Math.abs(x_center - x0), Math.abs(y_center - y0)};
        double[] q = {x2 - x0, y2 - y0};
        double[] u = {Math.max(p[0] - q[0], 0.0), Math.max(p[1] - q[1], 0.0)};

        return Math.sqrt(u[0] * u[0] + u[1] * u[1]) <= radius;
    }

    public static void main(String[] args) {
        int radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1;
        solution1401 s = new solution1401();
        System.out.println(s.checkOverlap(radius, x_center, y_center, x1, y1, x2, y2));
    }
}
