package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/30 21:15
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 *
 * 示例 1:
 * 输入:
 * words = ["w","wo","wor","worl", "world"]
 * 输出: "world"
 * 解释:
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 *
 * 示例 2:
 * 输入:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出: "apple"
 * 解释:
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 * 注意:
 *
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution720 {

    public String longestWord(String[] words) {
        String res = "";
        Set<String> wordSet = new HashSet<>();
        for (String x : words) {
            wordSet.add(x);
        }
        for (String x: words) {
            if (x.length() > res.length() || x.length() == res.length() && x.compareTo(res) < 0) {
                boolean sub = true;
                for (int i = 1; i < x.length(); i++) {
                    if (!wordSet.contains(x.substring(0, i))) {
                        sub = false;
                        break;
                    }
                }
                if (sub) {
                    res = x;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        solution720 s = new solution720();
        System.out.println(s.longestWord(words));
    }
}
