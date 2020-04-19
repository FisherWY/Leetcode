package solution_ez;

/**
 * @Author: Fisher
 * @Date: 2020/4/19 22:33
 */

/**
 * 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
 * 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
 * 例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
 * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。
 * 现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
 * 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
 *
 * 示例：
 * 输入：
 * s1 ="acb",n1 = 4
 * s2 ="ab",n2 = 2
 *
 * 返回：
 * 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-the-repetitions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count = 1;
        do {
           if (containsStr(s1, s2)) {
               break;
           } else {
               s1 += s1;
               count++;
           }
        } while (count <= n1);
        return n1 / (count * n2);
    }

    private int dp(String s1, int n1, String s2, int n2) {
        int res = 0;
        if (n1 == 0 || n2 == 0) {
            return res;
        }
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len2][2];
        int begin, tmpRes;
        // counting dp
        for (int i = 0; i < len2; i++) {
            begin = i;
            tmpRes = 0;
            for (int j = 0; j < len1; j++) {
                if (s1.charAt(j) == s2.charAt(begin)) {
                    begin++;
                }
                if (begin == len2) {
                    begin = 0;
                    tmpRes++;
                }
            }
            dp[i][0] = tmpRes;
            dp[i][1] = begin;
        }
        res = 0;
        begin = 0;
        for (int i = 0; i < n1; i++) {
            res += dp[begin][0];
            begin = dp[begin][1];
        }
        res = res / n2;
        return res;
    }

    private boolean containsStr(String s1, String s2) {
        int pos1 = 0, pos2 = 0;
        while (pos1 < s1.length() && pos2 < s2.length()) {
            if (s1.charAt(pos1) == s2.charAt(pos2)) {
                pos2++;
            }
            pos1++;
        }
        return pos2 == s2.length();
    }

    public static void main(String[] args) {
        String s1 = "acb", s2 = "ab";
        int n1 = 4, n2 = 2;
        solution466 s = new solution466();
        System.out.println(s.dp(s1, n1, s2, n2));
    }
}
