package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/29 22:01
 **/

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 不使用任何内建的哈希表库设计一个哈希映射
 * 具体地说，你的设计应该包含以下的功能
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 示例：
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 *
 * 注意：
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution706 {

    class Node {

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        int key;
        int val;
    }

    class MyHashMap {

        private static final int BUCKET_SIZE = 13;

        ArrayList<LinkedList<Node>> bucket = new ArrayList<>();

        private int hash(int key) {
            return key % BUCKET_SIZE;
        }

        /** Initialize your data structure here. */
        public MyHashMap() {
            for (int i = 0; i < BUCKET_SIZE; i++) {
                bucket.add(new LinkedList<>());
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hashValue = hash(key);
            LinkedList list = bucket.get(hashValue);
            for (int i = 0; i < list.size(); i++) {
                Node x = (Node) list.get(i);
                if (x.key == key) {
                    x.val = value;
                    return;
                }
            }
            list.add(new Node(key, value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hashValue = hash(key);
            LinkedList list = bucket.get(hashValue);
            for (int i = 0; i < list.size(); i++) {
                Node x = (Node) list.get(i);
                if (x.key == key) {
                    return x.val;
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hashValue = hash(key);
            LinkedList list = bucket.get(hashValue);
            for (int i = 0; i < list.size(); i++) {
                Node x = (Node) list.get(i);
                if (x.key == key) {
                    list.remove(i);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
