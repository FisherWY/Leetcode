package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/15 22:33
 **/

import java.util.LinkedList;
import java.util.List;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution155 {
    class MinStack {

        List<Integer> list;

        /** initialize your data structure here. */
        public MinStack() {
            list = new LinkedList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public void pop() {
            list.remove(list.size() - 1);
        }

        public int top() {
            if (list.size() != 0) {
                return list.get(list.size() - 1);
            } else {
                return 0;
            }
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for (Integer x : list) {
                min = x < min ? x : min;
            }
            return min;
        }
    }
}
