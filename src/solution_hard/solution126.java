package solution_hard;

/**
 * @Author Fisher
 * @Date 2020/6/7 19:51
 **/

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 *
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: []
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution126 {

    // 单词到ID的映射
    Map<String, Integer> wordId;
    // ID到单词的映射
    List<String> idWord;
    // 图的边
    ArrayList<Integer>[] edges;

    public solution126() {
        wordId = new HashMap<>();
        idWord = new ArrayList<>();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 将所有单词编号并加入到两个映射表中
        int id = 0;
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }
        // 若endWord不在映射表中，表示无解
        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        // 把beginWord加入到映射表中
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }
        // 初始化边数组
        edges = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }
        // 添加边
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        // 获取目标地址ID
        int dest = wordId.get(endWord);
        // 最终结果
        List<List<String>> res = new ArrayList<>();
        // 到每个点的代价，初始化为最大值
        int[] cost = new int[id];
        Arrays.fill(cost, Integer.MAX_VALUE);

        // 将起点加入队列，并将cost设置为0
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        queue.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        // 广度优先搜索遍历
        while (!queue.isEmpty()) {
            ArrayList<Integer> now = queue.poll();  // 该路径访问过的点的集合
            int last = now.get(now.size() - 1); // 最近访问过的点
            if (last == dest) { // 若该点就是终点，则存入答案中
                ArrayList<String> ans = new ArrayList<>();
                for (int index : now) {
                    ans.add(idWord.get(index));
                }
                res.add(ans);
            } else {    // 该点不是终点，继续搜索
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    if (cost[last] + 1 <= cost[to]) {   // 把代价相同的不同路径保存下来
                        cost[to] = cost[last] + 1;  // 更新最近访问点到达当前遍历的点的最短路径
                        // 复制now走过的路径，同时把点to加入到路径中，形成一条新路线
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        queue.add(tmp);
                    }
                }
            }
        }
        return res;
    }

    private boolean transformCheck(String str1, String str2) {
        int difference = 0;
        for (int i = 0; i < str1.length() && difference < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                difference++;
            }
        }
        return difference == 1;
    }
}
