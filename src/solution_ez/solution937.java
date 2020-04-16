package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/16 22:21
 **/

import java.util.Arrays;
import java.util.Comparator;

/**
 * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
 * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
 * 标识符后面的每个字将仅由小写字母组成，或；
 * 标识符后面的每个字将仅由数字组成。
 * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
 * 将日志重新排序，使得所有字母日志都排在数字日志之前。
 * 字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。
 * 返回日志的最终顺序。
 *
 * 示例 ：
 * 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 * 提示：
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] 保证有一个标识符，并且标识符后面有一个字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-data-in-log-files
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution937 {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, ((o1, o2) -> {
            String[] s1 = o1.split(" ", 2);
            String[] s2 = o2.split(" ", 2);
            // 数字日志
            boolean digit1 = Character.isDigit(s1[1].charAt(0));
            boolean digit2 = Character.isDigit(s2[1].charAt(0));
            // 字母日志
            if (!digit1 && !digit2) {
                int cmp = s1[1].compareTo(s2[1]);
                if (cmp != 0) {
                    return cmp;
                } else {
                    return s1[0].compareTo(s2[0]);
                }
            }
            // 数字日志比较
            return digit1 ? (digit2 ? 0 : 1) : -1;
        }));
        return logs;
    }
}
