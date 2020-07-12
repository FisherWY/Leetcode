package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/12 22:08
 **/

/**
 * 给你一个回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，且 不是 回文串。
 * 请你返回结果字符串。如果无法做到，则返回一个空串。
 *
 * 示例 1：
 * 输入：palindrome = "abccba"
 * 输出："aaccba"
 *
 * 示例 2：
 * 输入：palindrome = "a"
 * 输出：""
 *
 * 提示：
 * 1 <= palindrome.length <= 1000
 * palindrome 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/break-a-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1328 {

    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len <= 1) {
            return "";
        }

        int pos = -1;
        for (int i = 0; i < len / 2 + 1; i++) {
            if (palindrome.charAt(i) != 'a') {
                pos = i;
                break;
            }
        }
        String res = "";
        if (pos == -1 || pos == len / 2) {
            res = palindrome.substring(0, len - 1) + "b";
        } else {
            res = palindrome.substring(0, pos) + "a" + palindrome.substring(pos + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abccba";
        solution1328 s = new solution1328();
        System.out.println(s.breakPalindrome(str));
    }
}
