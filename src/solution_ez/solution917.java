package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/14 23:30
 **/

import java.util.Stack;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 示例 1：
 * 输入："ab-cd"
 * 输出："dc-ba"
 *
 * 示例 2：
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 *
 * 示例 3：
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * 提示：
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution917 {

    public String reverseOnlyLetters(String S) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char x : S.toCharArray()) {
            if (Character.isLetter(x)) {
                stack.push(x);
            }
        }
        for (char x : S.toCharArray()) {
            if (Character.isLetter(x)) {
                builder.append(stack.pop());
            } else {
                builder.append(x);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String S = "Qedo1ct-eeLg=ntse-T!";
        solution917 s = new solution917();
        System.out.println(s.reverseOnlyLetters(S));
    }
}
