package solution_hard;

/**
 * @Author: Fisher
 * @Date: 2020/5/23 21:29
 */

import java.util.Arrays;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution76 {

    public String minWindow(String s, String t) {
        int left = 0, right = 0, minLen = s.length(), minLeft = 0;
        int[] alphaS = new int[128], alphaT = new int[128];
        // 检查整串中是否存在字串满足条件
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alphaS[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            alphaT[c]++;
        }
        if (!check(alphaS, alphaT)) {
            return "";
        }
        // 滑动窗口寻找最小字串
        Arrays.fill(alphaS, 0);
        while (right < s.length()) {
            char c = s.charAt(right);
            alphaS[c]++;
            right++;
            while (check(alphaS, alphaT)) {
                char c1 = s.charAt(left);
                alphaS[c1]--;
                left++;
                // 更新最小字串长度
                int tmpLen = right - left + 1;
                if (tmpLen < minLen) {
                    minLen = tmpLen;
                    minLeft = left - 1;
                }
            }
        }
        return s.substring(minLeft, minLeft + minLen);
    }

    private boolean check(int[] alphaA, int[] alphaB) {
        for (int i = 65; i < 123; i++) {
            if (alphaA[i] < alphaB[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "a", T = "a";
        solution76 s = new solution76();
        System.out.println(s.minWindow(S, T));
    }
}
