package solution1_10;

/**
 * @Author Fisher
 * @Date 2019/7/15 17:41
 **/

/**
 * Question5：最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution5 {

    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        int pos = 0, length = 0;
        int status[][] = new int[s.length()][s.length()];
        String reverse = new StringBuffer(s).reverse().toString();
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<s.length(); j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i==0 || j==0) {
                        status[i][j] = 1;
                    } else {
                        status[i][j] = status[i-1][j-1] + 1;
                    }
                }
                if (status[i][j] > length) {
                    int origin_pos = s.length() - j - 1;
                    if (origin_pos + status[i][j] - 1 == i) {
                        length = status[i][j];
                        pos = i;
                    }
                }
            }
        }
        // System.out.println("pos: " + pos + " len:" + length);
        return s.substring(pos-length+1, pos+1);
    }

    public static void main(String[] args) {
        solution5 s5 = new solution5();
        String s = "babad";
        System.out.println(s5.longestPalindrome(s));

    }
}
