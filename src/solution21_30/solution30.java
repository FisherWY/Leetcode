package solution21_30;

/**
 * @Author Fisher
 * @Date 2019/8/5 10:02
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Question30：串联所有单词的字串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length()==0 || words.length==0) {
            return result;
        }
        // words数组中单个单词的长度
        int singleWordLength = words[0].length();
        HashMap<String, Integer> wordsMap = new HashMap<>();
        HashMap<String, Integer> resMap = new HashMap<>();
        // 将words数组中的单词添加到wordsMap中
        for (String x : words) {
            int num = wordsMap.getOrDefault(x, 0);
            wordsMap.put(x, num+1);
        }
        // 遍历字串s的下标从0到最后一组组合的下标开头
        for (int i=0; i<=(s.length()-words.length*singleWordLength); i++) {
            // 添加每个词，j控制添加次数
            for (int j=0; j<words.length; j++) {
                String w = s.substring(i+j*singleWordLength, i+(j+1)*singleWordLength);
                // 如果wordsMap中存在该单词，则添加到resMap中
                if (wordsMap.containsKey(w)) {
                    int num = resMap.getOrDefault(w, 0);
                    resMap.put(w, num+1);
                }
            }
            // 判断两个hashMap是否相同，如相同则为一种解
            if (resMap.equals(wordsMap)) {
                result.add(i);
            }
            // 清空resMap，继续求下一个解
            resMap.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"good","good","best","word"};
        String s = "wordgoodgoodgoodbestword";

        solution30 s30 = new solution30();
        List<Integer> res = s30.findSubstring(s, words);
        for (Integer x : res) {
            System.out.println(x);
        }
    }
}
