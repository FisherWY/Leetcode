package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/24 22:41
 **/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 *
 * 示例 1：
 * 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * 输出：2
 * 解释：子串 "aab" 在原字符串中出现了 2 次。
 * 它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
 *
 * 示例 2：
 * 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * 输出：2
 * 解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
 *
 * 示例 3：
 * 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * 输出：3
 *
 * 示例 4：
 * 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * 输出：0
 *
 * 提示：
 * 1 <= s.length <= 10^5
 * 1 <= maxLetters <= 26
 * 1 <= minSize <= maxSize <= min(26, s.length)
 * s 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1297 {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int len = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i + minSize > len) {
                break;
            }
            String str = s.substring(i, i + minSize);
            if (fun(str, maxLetters)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        int ansMax = 0;
        for (String str : map.keySet()) {
            int count = map.get(str);
            if (count > ansMax) {
                ansMax = count;
            }
        }
        return ansMax;
    }

    private boolean fun(String str, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
            if (set.size() > maxLetters) {
                return false;
            }
        }
        return true;
    }
}
