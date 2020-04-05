package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/5 23:34
 **/

/**
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * 说明:
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution821 {

    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];

        for (int i = 0; i < S.length(); i++) {
            // 该字符是C
            if (S.charAt(i) == C) {
                res[i] = 0;
                continue;
            }
            // 左右两边寻找最近的C
            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            // 往左边找
            for (int j = i - 1; j >= 0; j--) {
                if (S.charAt(j) == C) {
                    left = i - j;
                    break;
                }
            }
            // 往右边找
            for (int j = i + 1; j < S.length(); j++) {
                if (S.charAt(j) == C) {
                    right = j - i;
                    break;
                }
            }
            res[i] = (left < right ? left : right);
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        solution821 s = new solution821();
        for (int x : s.shortestToChar(S, C)) {
            System.out.print(x + " ");
        }
    }
}
