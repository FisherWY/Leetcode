package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/15 21:49
 **/

/**
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 示例 1:
 * 输入: "PPALLP"
 * 输出: True
 *
 * 示例 2:
 * 输入: "PPALLL"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution551 {

    public boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        int absent = 0, late = 0;
        for (char x : arr) {
            if (x == 'A') {
                absent++;
            }
            if (x == 'L') {
                late++;
            } else {
                late = 0;
            }
            if (absent > 1) {
                return false;
            }
            if (late > 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "PPALLP";
        solution551 s = new solution551();
        if (s.checkRecord(str)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
