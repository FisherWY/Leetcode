package solution11_20;

/**
 * @Author Fisher
 * @Date 2019/7/26 21:09
 **/

import java.util.Stack;

/**
 * Question20：有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution20 {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (stack.empty()) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                String str = stack.peek();
                String current = String.valueOf(s.charAt(i));
                switch (str) {
                    case "(":
                        if (current.equals("(") || current.equals("{") || current.equals("[")) {
                            stack.push(current);
                            break;
                        } else if (current.equals(")")) {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    case "{":
                        if (current.equals("(") || current.equals("{") || current.equals("[")) {
                            stack.push(current);
                            break;
                        } else if (current.equals("}")) {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    case "[":
                        if (current.equals("(") || current.equals("{") || current.equals("[")) {
                            stack.push(current);
                            break;
                        } else if (current.equals("]")) {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    default:
                        return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "{}";
        solution20 s20 = new solution20();
        if (s20.isValid(s)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
