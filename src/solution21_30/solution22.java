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
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        fun(result, 0, 0, n, new StringBuilder());
        return result;
    }

    private void fun(List<String> res, int left, int right, int n, StringBuilder s) {
        // 左括号可以填
        if (left < n) {
            // 填左括号
            s.append('(');
            // 左括号数+1
            fun(res, left+1, right, n, s);
            // 回溯
            s.deleteCharAt(s.length()-1);
        }
        // 右括号可以填
        if (left > right) {
            // 填右括号
            s.append(')');
            // 右括号数+1
            fun(res, left, right+1, n, s);
            // 回溯
            s.deleteCharAt(s.length()-1);
        }
        // 填完了，并且左括号数量等于右括号
        if (left == n && left == right) {
            res.add(s.toString());
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
