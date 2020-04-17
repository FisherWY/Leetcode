package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/17 21:57
 **/

/**
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 * 示例 1：
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 *
 * 示例 2：
 * 输出："III"
 * 输出：[0,1,2,3]
 *
 * 示例 3：
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *
 * 提示：
 * 1 <= S.length <= 10000
 * S 只包含字符 "I" 或 "D"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution942 {

    public int[] diStringMatch(String S) {
        int left = 0, right = S.length();
        int[] res = new int[right + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
        }
        res[S.length()] = left;
        return res;
    }

    public static void main(String[] args) {
        String S = "III";
        solution942 s = new solution942();
        for (int x : s.diStringMatch(S)) {
            System.out.print(x + " ");
        }
    }
}
