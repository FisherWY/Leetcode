package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/2 21:45
 **/

import java.util.*;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 *
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 *
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *  
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int gap = -(arr[i] - arr[i + 1]);
            if (gap < min) {
                min = gap;
                res.clear();
                // 添加结果
                List<Integer> list = new ArrayList<>(2);
                list.add(arr[i]);
                list.add(arr[i + 1]);
                res.add(list);
            } else if (gap == min) {
                // 添加结果
                List<Integer> list = new ArrayList<>(2);
                list.add(arr[i]);
                list.add(arr[i + 1]);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        solution1200 s = new solution1200();
        for (List<Integer> list : s.minimumAbsDifference(arr)) {
            for (Integer x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
