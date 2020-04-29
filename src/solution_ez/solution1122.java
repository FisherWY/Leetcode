package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/29 22:20
 **/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。 
 *
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 提示：
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        int pos = 0, begin = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr1) {
            int count = map.getOrDefault(x, 0);
            map.put(x, count + 1);
        }
        for (int x : arr2) {
            if (map.containsKey(x)) {
                for (int i = 0; i < map.get(x); i++) {
                    res[pos] = x;
                    pos++;
                }
            }
            map.remove(x);
        }
        begin = pos;
        for (int x : map.keySet()) {
            for (int i = 0; i < map.get(x); i++) {
                res[pos] = x;
                pos++;
            }
        }
        Arrays.sort(res, begin, pos);
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        solution1122 s = new solution1122();
        for (int x : s.relativeSortArray(arr1, arr2)) {
            System.out.print(x + " ");
        }
    }
}
