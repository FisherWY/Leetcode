package 面试题;

/**
 * @Author Fisher
 * @Date 2020/6/22 21:02
 **/

/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 *
 * 示例 2：
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 *
 * 示例 3：
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 *
 * 示例 4：
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 *
 * 提示：
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem16_18 {

    public boolean patternMatching(String pattern, String value) {
        int count_a = 0, count_b = 0;
        // 统计pattern中a、b的数量
        for (char c : pattern.toCharArray()) {
            if (c == 'a') {
                count_a++;
            } else {
                count_b++;
            }
        }
        // 保证count_a比count_b大，并且将pattern中对应字母数量关系修正，保证a比b多
        if (count_a < count_b) {
            // 交换a、b的count值
            int tmp = count_a;
            count_a = count_b;
            count_b = tmp;
            // 翻转pattern
            char[] arr = pattern.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (arr[i] == 'a' ? 'b' : 'a');
            }
            pattern = new String(arr);
        }
        // value为空的情况，只要pattern只存在一种字母即可
        if (value.length() == 0) {
            return count_b == 0;
        }
        // pattern为空，无法满足匹配
        if (pattern.length() == 0) {
            return false;
        }
        // 枚举每种情况
        for (int len_a = 0; count_a * len_a <= value.length(); len_a++) {
            int rest = value.length() - count_a * len_a;
            // 剩余长度能够形成pattern
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = (count_b == 0 ? 0 : rest / count_b);
                int pos = 0;
                boolean correct = true;
                String value_a = "", value_b = "";
                // 模式匹配
                for (char c : pattern.toCharArray()) {
                    if (c == 'a') {
                        // 截取pattern_a对应的子串
                        String sub = value.substring(pos, pos + len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {  // 出现不匹配的情况
                            correct = false;
                            break;
                        }
                        pos += len_a;
                    } else {
                        String sub = value.substring(pos, pos + len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_b;
                    }
                }
                if (correct && !value_a.equals(value_b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String pattern = "abba", value = "dogcatcatdog";
        Problem16_18 p = new Problem16_18();
        System.out.println(p.patternMatching(pattern, value));
    }
}
