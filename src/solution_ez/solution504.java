package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/11 22:40
 **/

/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 * 输入: 100
 * 输出: "202"
 *
 * 示例 2:
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution504 {

    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-1 * num);
        }
        if (num < 7) {
            return String.valueOf(num);
        }
        return convertToBase7(num / 7) + String.valueOf(num % 7);
    }

    public static void main(String[] args) {
        int num = -7;
        solution504 s = new solution504();
        System.out.println(s.convertToBase7(num));
    }
}
