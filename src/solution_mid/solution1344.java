package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/5 21:39
 **/

/**
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 *
 * 示例 1：
 * 输入：hour = 12, minutes = 30
 * 输出：165
 *
 * 示例 2：
 * 输入：hour = 3, minutes = 30
 * 输出；75
 *
 * 示例 3：
 * 输入：hour = 3, minutes = 15
 * 输出：7.5
 *
 * 示例 4：
 * 输入：hour = 4, minutes = 50
 * 输出：155
 *
 * 示例 5：
 * 输入：hour = 12, minutes = 0
 * 输出：0
 *
 * 提示：
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * 与标准答案误差在 10^-5 以内的结果都被视为正确结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/angle-between-hands-of-a-clock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1344 {

    public double angleClock(int hour, int minutes) {
        int minAngle = 6, hourAngle = 30;
        double m = minutes * minAngle;
        double h = (hour % 12 + minutes / 60.0) * hourAngle;
        double angle = Math.abs(m - h);
        return Math.min(angle, 360 - angle);
    }

    public static void main(String[] args) {
        int hour = 12, minutes = 30;
        solution1344 s = new solution1344();
        System.out.println(s.angleClock(hour, minutes));
    }
}
