package solution_mid;

/**
 * @Author: Fisher
 * @Date: 2020/7/19 17:37
 */

import java.util.*;

/**
 * 有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
 * 给你数组 watchedVideos 和 friends ，其中 watchedVideos[i] 和 friends[i] 分别表示 id = i 的人观看过的视频列表和他的好友列表。
 * Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，以此类推。
 * 一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
 * 给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。如果有频率相同的视频，请将它们按字母顺序从小到大排列。
 *
 * 示例 1：
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 * 输出：["B","C"]
 * 解释：
 * 你的 id 为 0（绿色），你的朋友包括（黄色）：
 * id 为 1 -> watchedVideos = ["C"] 
 * id 为 2 -> watchedVideos = ["B","C"] 
 * 你朋友观看过视频的频率为：
 * B -> 1 
 * C -> 2
 *
 * 示例 2：
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 * 输出：["D"]
 * 解释：
 * 你的 id 为 0（绿色），你朋友的朋友只有一个人，他的 id 为 3（黄色）。
 *
 * 提示：
 * n == watchedVideos.length == friends.length
 * 2 <= n <= 100
 * 1 <= watchedVideos[i].length <= 100
 * 1 <= watchedVideos[i][j].length <= 8
 * 0 <= friends[i].length < n
 * 0 <= friends[i][j] < n
 * 0 <= id < n
 * 1 <= level < n
 * 如果 friends[i] 包含 j ，那么 friends[j] 包含 i
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-watched-videos-by-your-friends
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1311 {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // 找出指定level的好友
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[friends.length];
        queue.offer(id);
        visited[id] = true;
        while (level > 0) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                int tmpId = queue.poll();
                for (int friendId : friends[tmpId]) {
                    if (!visited[friendId]) {
                        queue.offer(friendId);
                        visited[friendId] = true;
                    }
                }
            }
            level--;
        }
        // 统计好友观看的视频次数
        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int tmpId = queue.poll();
            for (String x : watchedVideos.get(tmpId)) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        // 对视频频率进行排序
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            int res = o1.getValue() - o2.getValue();
            return res == 0 ? o1.getKey().compareTo(o2.getKey()) : res;
        }));
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            priorityQueue.offer(item);
        }
        List<String> res = new ArrayList<>(priorityQueue.size());
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll().getKey());
        }
        return res;
    }

}
