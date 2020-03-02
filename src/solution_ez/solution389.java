package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/2 22:05
 **/

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution389 {

    public char findTheDifference(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        alphabet[t.charAt(t.length() - 1) - 'a']--;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                return (char)(i + 'a');
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        String str = "abcd";
        String t = "abcde";
        solution389 s = new solution389();
        System.out.println(s.findTheDifference(str, t));
    }
}
