package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/2 21:34
 **/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * 示例 1：
 * 输入：text = "nlaebolko"
 * 输出：1
 *
 * 示例 2：
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 *
 * 示例 3：
 * 输入：text = "leetcode"
 * 输出：0
 *  
 * 提示：
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1189 {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);
        for (char x : text.toCharArray()) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            }
        }
        map.put('l', map.get('l') / 2);
        map.put('o', map.get('o') / 2);
        int res = Integer.MAX_VALUE;
        for (char x : map.keySet()) {
            res = Math.min(res, map.get(x));
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        String text = "leetcode";
        solution1189 s = new solution1189();
        System.out.println(s.maxNumberOfBalloons(text));
    }
}
