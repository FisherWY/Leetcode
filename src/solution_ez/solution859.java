package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/8 21:17
 **/

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 示例 1：
 * 输入： A = "ab", B = "ba"
 * 输出： true
 *
 * 示例 2：
 * 输入： A = "ab", B = "ab"
 * 输出： false
 *
 * 示例 3:
 * 输入： A = "aa", B = "aa"
 * 输出： true
 *
 * 示例 4：
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 *
 * 示例 5：
 * 输入： A = "", B = "aa"
 * 输出： false
 *
 * 提示：
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution859 {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            int[] alpha = new int[26];
            for (char x : A.toCharArray()) {
                alpha[x - 'a']++;
                if (alpha[x - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return (first != -1 && second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
        }
    }

    public static void main(String[] args) {
        String A = "aaaaaaabc", B = "aaaaaaacb";
        solution859 s = new solution859();
        System.out.println(s.buddyStrings(A, B));
    }
}
