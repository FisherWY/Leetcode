package solution21_30;

/**
 * @Author Fisher
 * @Date 2019/7/28 10:36
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * Question22：括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution22 {

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(0, 0, n, new StringBuilder());
        return list;
    }

    private void helper(int left, int right, int n, StringBuilder s) {
        if (left < n) {
            s.append('(');
            helper(left + 1, right, n, s);
            s.deleteCharAt(s.length() - 1);
        }
        if (left > right) {
            s.append(')');
            helper(left, right + 1, n, s);
            s.deleteCharAt(s.length() - 1);
        }
        if (left == n && right == n) {
            list.add(s.toString());
        }
    }

    public static void main(String[] args) {
        solution22 s22 = new solution22();
        List<String> result = s22.generateParenthesis(2);
        for (String x : result) {
            System.out.println(x);
        }
    }
}
