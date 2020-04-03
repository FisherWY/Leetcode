package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/3 22:25
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution784 {

    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> res = new ArrayList<>();
        res.add(new StringBuilder());

        for (char x : S.toCharArray()) {
            int size = res.size();
            if (Character.isLetter(x)) {
                for (int i = 0; i < size; i++) {
                    res.add(new StringBuilder(res.get(i)));
                    res.get(i).append(Character.toLowerCase(x));
                    res.get(i + size).append(Character.toUpperCase(x));
                }
            } else {
                for (int i = 0; i < size; i++) {
                    res.get(i).append(x);
                }
            }
        }

        List<String> list = new ArrayList<>();
        for (StringBuilder sb : res) {
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        String S = "a1b2";
        solution784 s = new solution784();
        List<String> list = s.letterCasePermutation(S);
        for (String x : list) {
            System.out.println(x);
        }
    }
}
