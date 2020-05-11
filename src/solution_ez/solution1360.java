package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/11 21:08
 **/

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 *
 * 示例 1：
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 *
 * 示例 2：
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 *  
 * 提示：
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-days-between-two-dates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1360 {

    public int daysBetweenDates(String date1, String date2) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = format1.parse(date1);
            Date d2 = format2.parse(date2);
            long res = Math.abs(d1.getTime() - d2.getTime()) / (1000 * 24 * 60 * 60);
            return (int) res;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        String date1 = "2020-01-15", date2 = "2019-12-31";
        solution1360 s = new solution1360();
        System.out.println(s.daysBetweenDates(date1, date2));
    }
}
