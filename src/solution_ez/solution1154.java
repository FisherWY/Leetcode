package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/30 21:48
 **/

/**
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 * 示例 1：
 * 输入：date = "2019-01-09"
 * 输出：9
 *
 * 示例 2：
 * 输入：date = "2019-02-10"
 * 输出：41
 *
 * 示例 3：
 * 输入：date = "2003-03-01"
 * 输出：60
 *
 * 示例 4：
 * 输入：date = "2004-03-01"
 * 输出：61
 *
 * 提示：
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1154 {

    int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31};

    public int dayOfYear(String date) {
        int res = 0;
        String[] calender = date.split("-");
        int year = Integer.parseInt(calender[0]), month = Integer.parseInt(calender[1]), day = Integer.parseInt(calender[2]);
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            arr[1]++;
        }
        for (int i = 0; i < month - 1; i++) {
            res += arr[i];
        }
        res += day;
        return res;
    }

    public static void main(String[] args) {
        String date = "1900-03-25";
        solution1154 s = new solution1154();
        System.out.println(s.dayOfYear(date));
    }
}
