package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/26 21:53
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");
        if (p.length != s.length) {
            return false;
        }
        for (int i = 0; i < p.length; i++) {
            if (map.containsValue(s[i]) && !map.containsKey(p[i])) {
                return false;
            }
            if (!map.containsKey(p[i]) && !map.containsValue(s[i])) {
                map.put(p[i], s[i]);
                continue;
            }
            if (!s[i].equals(map.get(p[i]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        solution290 s = new solution290();
        if (s.wordPattern(pattern, str)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
