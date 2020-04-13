package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/13 22:31
 **/

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.*;

/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。
 * 你的设计需要支持以下的几个功能：
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 *
 * 示例:
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution355 {

    class Tweet {
        public int id;
        public int timestamp;
        public Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    class Twitter {

        // 储存用户发表的推文
        private Map<Integer, Tweet> twitter;

        // 用户的关注列表
        private Map<Integer, Set<Integer>> following;

        // 服务器时间戳
        private int timestamp = 0;

        // 合并K组推文使用的数据结构
        private PriorityQueue<Tweet> maxHeap;

        /** Initialize your data structure here. */
        public Twitter() {
            following = new HashMap<>();
            twitter = new HashMap<>();
            maxHeap = new PriorityQueue<>(((o1, o2) -> -o1.timestamp + o2.timestamp));
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            timestamp++;
            if (twitter.containsKey(userId)) {
                Tweet oldHead = twitter.get(userId);
                Tweet newHead = new Tweet(tweetId, timestamp);
                newHead.next = oldHead;
                twitter.put(userId, newHead);
            } else {
                twitter.put(userId, new Tweet(tweetId, timestamp));
            }
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            maxHeap.clear();
            if (twitter.containsKey(userId)) {
                maxHeap.offer(twitter.get(userId));
            }

            Set<Integer> followingList = following.get(userId);
            if (followingList != null && followingList.size() > 0) {
                for (Integer x : followingList) {
                    Tweet tweet = twitter.get(x);
                    if (tweet != null) {
                        maxHeap.offer(tweet);
                    }
                }
            }

            List<Integer> res = new ArrayList<>(10);
            int count = 0;
            while (!maxHeap.isEmpty() && count < 10) {
                Tweet head = maxHeap.poll();
                res.add(head.id);
                if (head.next != null) {
                    maxHeap.offer(head.next);
                }
                count++;
            }
            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }

            Set<Integer> followingList = following.get(followerId);
            if (followingList == null) {
                Set<Integer> init = new HashSet<>();
                init.add(followeeId);
                following.put(followerId, init);
            } else {
                if (followingList.contains(followeeId)) {
                    return;
                }
                followingList.add(followeeId);
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }

            Set<Integer> followingList = following.get(followerId);
            if (followingList == null) {
                return;
            }
            followingList.remove(followeeId);
        }
    }

}
