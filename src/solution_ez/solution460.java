package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/5 21:48
 **/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近 最少使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 * LFUCache cache = new LFUCache( 2 )   // 缓存容量
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回 1
 * cache.put(3, 3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4, 4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lfu-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class solution460 {

    static class Node implements Comparable<Node> {
        int key;
        int value;
        int count;
        int time;

        public Node() {}

        public Node(int key, int value, int time) {
            this.key = key;
            this.value = value;
            this.count = 1;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            int diff = count - o.count;
            return diff != 0 ? diff : time - o.time;
        }
    }

    static class LFUCache {

        /**
         * size: cache当前大小
         * capacity: cache最大值
         * timer: 程序计数器，计算cache运行时间
         */
        int size, capacity, timer = 0;
        // cache: 缓存，储存key和node
        Map<Integer, Node> cache;
        // 优先级队列，通过Node中的count计数器和time计数器，最先获得count最小和time最小的Node
        Queue<Node> queue;

        public LFUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            cache = new HashMap<>();
            if (capacity > 0) {
                queue = new PriorityQueue<>(capacity);
            }
        }

        public int get(int key) {
            Node node = cache.get(key);
            // 找不到该key
            if (node == null) {
                return -1;
            }
            node.count++;
            // 更新最近使用时间
            node.time = timer++;
            queue.remove(node);
            queue.offer(node);
            return node.value;
        }

        public void put(int key, int value) {
            // cache没有容量
            if (this.capacity <= 0) {
                return;
            }
            Node node = cache.get(key);
            // key存在，更新值
            if (node != null) {
                node.value = value;
                node.count++;
                node.time = timer++;
                queue.remove(node);
                queue.offer(node);
            } else {
                if (size == capacity) {
                    cache.remove(queue.peek().key);
                    queue.poll();
                    size--;
                }
                Node newNode = new Node(key, value, timer++);
                cache.put(key, newNode);
                queue.offer(newNode);
                size++;
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(2,1);
        cache.put(3,2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}
