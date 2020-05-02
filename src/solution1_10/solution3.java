package solution1_10;

/**
 * @Author Fisher
 * @Date 2019/7/15 17:32
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * Question3：无重复的最长字串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 题目要求的是无重复，因此使用map来记录出现的字母，在字母重复出现之后立即返回。
 */
public class solution3 {

    /**
     * 2020-5-2 时隔一年再刷，凭自己的能力做出来了
     * 使用了滑动窗口的思想，记录下最大的无重复字母窗口
     * @param s
     * @return int
     */
    private int newfun(String s) {
        int max = 0, cur = 0;
        // 记录每个字母的下标
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 将出现重复字母前面的删除
                for (int j = i - cur; j < map.get(c); j++) {
                    map.remove(s.charAt(j));
                }
                // 更新窗口
                cur = i - map.get(c);
                // 更新当前重复字母的下标
                map.put(c, i);
            } else {
                map.put(c, i);
                cur++;
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            int x = fun(s, i);
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    public int fun(String s, int pos) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = pos; i < s.length(); i++) {
            String x = String.valueOf(s.charAt(i));
            if (map.get(x) != null) {
                return map.size();
            } else {
                map.put(x, 0);
            }
        }
        return map.size();
    }

    public static void main(String[] args) {
        solution3 s3 = new solution3();
        String str = "abcabcbb";
        System.out.println(s3.lengthOfLongestSubstring(str));
    }
}
