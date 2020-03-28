package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/28 21:43
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合
 * 具体地说，你的设计应该包含以下的功能
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);        
 * hashSet.add(2);        
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);          
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 注意：
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution705 {
    static class MyHashSet {

        private static final int BUCKET_SIZE = 13;
        ArrayList<LinkedList<Integer>> bucket = new ArrayList<>();

        /** Initialize your data structure here. */
        public MyHashSet() {
            for (int i = 0; i < BUCKET_SIZE; i++) {
                bucket.add(new LinkedList<>());
            }
        }

        private int hash(int key) {
            return key % BUCKET_SIZE;
        }

        public void add(int key) {
            int hash = hash(key);
            LinkedList<Integer> list = bucket.get(hash);
            for (Integer x : list) {
                if (x == key) {
                    return;
                }
            }
            list.add(key);
        }

        public void remove(int key) {
            int hash = hash(key);
            LinkedList<Integer> list = bucket.get(hash);
            for (int i = 0; i < list.size(); i++) {
                if (key == list.get(i)) {
                    list.remove(i);
                    return;
                }
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int hash = hash(key);
            LinkedList<Integer> list = bucket.get(hash);
            for (int i = 0; i < list.size(); i++) {
                if (key == list.get(i)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(1);
        obj.remove(1);
        boolean param_3 = obj.contains(1);
        System.out.println(param_3);
    }
}
