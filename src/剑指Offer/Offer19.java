package 剑指Offer;

public class Offer19 {
    public boolean isMatch(String s, String p) {
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        boolean ans;
        // 结束条件，pattern用完了
        if (j == p.length()) {
            ans = (i == s.length());    // 如果此时string也到了尾部，则正则匹配成功
        } else {
            // 当前情况，第一个字母的匹配情况：字母相同或pattern是'.'
            boolean first_match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
            // 下一个字母是否为'*'
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // 如果是'*'，则有2种情况：当前字母出现0次，即跳过当前pattern；或当前字母出现多次
                ans = dp(i, j + 2, s, p) || (first_match && dp(i + 1, j, s, p));
            } else {
                ans = first_match && dp(i + 1, j + 1, s, p);    // 不是'*'，正常进入下一个dp
            }
        }
        return ans;
    }
}
