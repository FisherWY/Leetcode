package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/11 21:19
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * 返回所有不常用单词的列表。
 * 您可以按任何顺序返回列表。
 *
 * 示例 1：
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 *
 * 示例 2：
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 *  
 * 提示：
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution884 {

    public String[] uncommonFromSentences(String A, String B) {
        List<String> res = new ArrayList<>();
        String[] arrA = A.split(" ");
        String[] arrB = B.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String x : arrA) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (String x : arrB) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (String x : map.keySet()) {
            if (map.get(x) == 1) {
                res.add(x);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String str1 = "this apple is sweet";
        String str2 = "this apple is soul";
        solution884 s = new solution884();
        String[] res = s.uncommonFromSentences(str1, str2);
        for (String x : res) {
            System.out.println(x);
        }
    }
}
