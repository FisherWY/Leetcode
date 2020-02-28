package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/28 22:18
 **/

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 *
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution345 {

    private char[] regex = {'a','e','i','o','u','A','E','I','O','U'};

    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int left = 0, right = c.length - 1;
        char tmp;
        while (left < right) {
            while (left < right && !fun(c[left])) {
                left++;
            }
            while (left < right && !fun(c[right])) {
                right--;
            }
            tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left++;
            right--;
        }
        String res = new String(c);
        return res;
    }

    private boolean fun(char x) {
        for (char c : regex) {
            if (c == x) {
                return true;
            }
        }
        return false;
    }
}
