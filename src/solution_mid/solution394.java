package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/5/28 21:36
 **/

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution394 {

    private int lastEnd = 0;

    public String decodeString(String s) {
        return fun(s, 0);
    }

    private String fun(String s, int pos) {
        String res = "";
        int times = 0;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (Character.isDigit(c)) {
                times = times * 10 + (c - '0');
                pos++;
                continue;
            }
            if (c == '[') {
                String tmp = fun(s, pos + 1);
                while (times > 0) {
                    res += tmp;
                    times--;
                }
                pos = (lastEnd > pos ? lastEnd + 1 : pos + 1);
                continue;
            }
            if (c == ']') {
                lastEnd = pos;
                break;
            }
            res += c;
            pos++;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "2[abc]3[cd]ef";
        solution394 s = new solution394();
        System.out.println(s.decodeString(str));
    }
}
