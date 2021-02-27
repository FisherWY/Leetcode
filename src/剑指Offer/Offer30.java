package 剑指Offer;

import java.util.Stack;

public class Offer30 {

    class MinStack {

        Stack<Integer> stack = null;   // 按照正常顺序入栈的stack
        Stack<Integer> desStack = null;    // 降序stack

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            desStack = new Stack<>();
        }
        
        public void push(int x) {
            stack.push(x);
            if (desStack.isEmpty() || desStack.peek() >= x) {
                desStack.push(x);
            }
        }
        
        public void pop() {
            if (desStack.peek().equals(stack.peek())) { // 注意这里要用equals方法，因为比较的是两个Integer对象
                desStack.pop();
            }
            stack.pop();
        }
        
        public int top() {
            return stack.peek();    
        }
        
        public int min() {
            return desStack.peek();
        }
    }
}
