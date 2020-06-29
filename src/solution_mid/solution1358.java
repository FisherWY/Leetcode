package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/29 20:37
 **/

/**
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 *
 * 示例 1：
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 *
 * 示例 2：
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 *
 * 示例 3：
 * 输入：s = "abc"
 * 输出：1
 *
 * 提示：
 * 3 <= s.length <= 5 x 10^4
 * s 只包含字符 a，b 和 c 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-substrings-containing-all-three-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1358 {

    // 超时解法
    public int numberOfSubstrings(String s) {
        int left = 0, right = 0, res = 0;
        while (right <= s.length()) {
            if (fun(s.substring(left, right))) {
                System.out.println(s.substring(left, right) + " count: " + (s.length() - right + 1));
                res += s.length() - right + 1;
                left++;
                continue;
            }
            right++;
        }
        return res;
    }

    private boolean fun(String s) {
        boolean hasA = false, hasB = false, hasC = false;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (count == 3) {
                return true;
            }
            if (c == 'a') {
                if (!hasA) {
                    count++;
                }
                hasA = true;
            } else if (c == 'b') {
                if (!hasB) {
                    count++;
                }
                hasB = true;
            } else if (c == 'c') {
                if (!hasC) {
                    count++;
                }
                hasC = true;
            }
        }
        return hasA && hasB && hasC;
    }


    private int fun1(String s) {
        int[] count = new int[3];
        int len = s.length(), res = 0;
        for (int left = 0, right = -1; left < len;) {
            while (right < len && !(count[0] >= 1 && count[1] >= 1 && count[2] >= 1)) {
                if (++right == len) {
                    break;
                }
                count[s.charAt(right) - 'a']++;
            }
            res += len - right;
            count[s.charAt(left++) - 'a']--;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "aaacb";
        solution1358 s = new solution1358();
        System.out.println(s.fun1(str));
    }
}
