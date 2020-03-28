package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/28 21:09
 **/

import java.util.Arrays;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution703 {

    static class KthLargest {

        int[] window;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.window = new int[k];
            Arrays.fill(window, Integer.MIN_VALUE);
            for (int x : nums) {
                add(x);
            }
        }

        public int add(int val) {
            for (int i = window.length - 1; i >= 0; i--) {
                if (window[i] <= val) {
                    for (int j = 0; j < i; j++) {
                        window[j] = window[j + 1];
                    }
                    window[i] = val;
                    break;
                }
            }
            return window[window.length - k];
        }
    }

    public static void main(String[] args) {
        int k = 1;
        int[] arr = {};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(4));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(5));
    }
}
