package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/30 22:20
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，
 * 其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 *
 * 示例 1：
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 *
 * 示例 2：
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 *
 * 提示：
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] 都是小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1170 {

    /**
     * 实在是搞不懂为啥我这个方法错了，我觉得没问题哇
     * @param queries
     * @param words
     * @return int[]
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int min = count(word);
            map.put(min, map.getOrDefault(min, 0) + 1);
        }
        for (int i = 0; i < queries.length; i++) {
            int tmp = 0;
            int min = count(queries[i]);
            for (int key : map.keySet()) {
                if (key > min) {
                    tmp += map.get(key);
                }
            }
            res[i] = tmp;
        }
        return res;
    }

    private int count(String s) {
        int[] alpha = new int[26];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }
        for (int x : alpha) {
            if (x != 0 && x < min) {
                min = x;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] queries = {"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
        String[] words = {"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
        solution1170 s = new solution1170();
        for (int x : s.numSmallerByFrequency(queries, words)) {
            System.out.print(x + " ");
        }
    }

}
