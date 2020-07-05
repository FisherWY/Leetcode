package solution_hard;

/**
 * @Author Fisher
 * @Date 2020/7/5 21:20
 **/

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 *
 * 示例 3:
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 * 示例 4:
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 *
 * 示例 5:
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution44 {

    public boolean isMatch(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        // 初始化边界条件
        dp[0][0] = true;
        for (int i = 1; i <= lenP; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        // 动态规划
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if (p.charAt(j - 1) == '*') {   // 当前pattern是星号的情况
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {  // 当前pattern等于字符穿或pattern是问号
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[lenS][lenP];
    }

    public static void main(String[] args) {
        String str = "aa", pattern = "a*";
        solution44 s = new solution44();
        System.out.println(s.isMatch(str, pattern));
    }
}
