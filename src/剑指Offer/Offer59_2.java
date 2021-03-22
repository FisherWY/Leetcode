package 剑指Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Offer59_2 {
    class MaxQueue {

        private Queue<Integer> queue;
        private Deque<Integer> maxQueue;

        public MaxQueue() {
            queue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }
        
        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
        }
        
        public void push_back(int value) {
            queue.offer(value);
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(value);
        }
        
        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int res = queue.poll();
            if (maxQueue.peekFirst() == res) {
                maxQueue.removeFirst();
            }
            return res;
        }
    }
}
