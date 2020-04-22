package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/21 21:46
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1002 {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[][] set = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            for (int j = 0; j < s.length(); j++) {
                set[i][s.charAt(j) - 'a']++;
            }
        }
        for (int col = 0; col < set[0].length; col++) {
            int min = set[0][col];
            for (int row = 1; row < set.length; row++) {
                if (set[row][col] == 0) {
                    min = 0;
                    break;
                } else {
                    min = Math.min(min, set[row][col]);
                }
            }
            if (min != 0) {
                for (int i = 0; i < min; i++) {
                    res.add(String.valueOf((char)('a' + col)));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] A = {"cool","lock","cook"};
        solution1002 s = new solution1002();
        List<String> res = s.commonChars(A);
        for (String x : res) {
            System.out.println(x);
        }
    }
}
