package 剑指Offer;

import java.util.Stack;

public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushPtr = 0, popPtr = 0;
        while (pushPtr < pushed.length && popPtr < popped.length) {
            if (stack.isEmpty()) {
                stack.push(pushed[pushPtr]);
                pushPtr++;
                continue;
            }
            if (stack.peek() == popped[popPtr]) {
                stack.pop();
                popPtr++;
            } else {
                stack.push(pushed[pushPtr]);
                pushPtr++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() == popped[popPtr]) {
                popPtr++;
            } else {
                return false;
            }
        }
        return popPtr == popped.length;
    }
}
