package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/15 22:08
 **/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * 示例 1：
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 *
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 *
 * 示例 3：
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 *
 * 示例 4：
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 *
 * 示例 5：
 * 输入：s = "ab123"
 * 输出："1a2b3"
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reformat-the-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1417 {

    public String reformat(String s) {
        List<Character> list1 = new ArrayList<>(s.length() / 2 + 1);
        List<Character> list2 = new ArrayList<>(s.length() / 2 + 1);
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) {
                list1.add(x);
            } else {
                list2.add(x);
            }
        }
        if (Math.abs(list1.size() - list2.size()) > 1) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int pos = 0;
        if (list1.size() < list2.size()) {
            while (pos < list1.size() && pos < list2.size()) {
                builder.append(list2.get(pos));
                builder.append(list1.get(pos));
                pos++;
            }
        } else {
            while (pos < list1.size() && pos < list2.size()) {
                builder.append(list1.get(pos));
                builder.append(list2.get(pos));
                pos++;
            }
        }

        if (pos < list1.size()) {
            builder.append(list1.get(pos));
        } else if (pos < list2.size()){
            builder.append(list2.get(pos));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "1229857369";
        solution1417 s = new solution1417();
        System.out.println(s.reformat(str));
    }
}
