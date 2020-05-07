package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/7 21:51
 **/

import java.util.Arrays;

/**
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 *
 * 示例：
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 *  
 * 提示：
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1299 {

    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int left = 0, right = 0;
        while (right != arr.length - 1) {
            right = findMax(arr, right + 1);
            Arrays.fill(res, left, right, arr[right]);
            left = right;
        }
        res[arr.length - 1] = -1;
        return res;
    }

    private int findMax(int[] arr, int start) {
        int max = arr[start], pos = start, res = start;
        while (pos < arr.length) {
            if (arr[pos] >= max) {
                max = arr[pos];
                res = pos;
            }
            pos++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        solution1299 s = new solution1299();
        for (int x : s.replaceElements(arr)) {
            System.out.print(x + " ");
        }
    }
}
