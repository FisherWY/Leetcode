package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/1 20:58
 **/

import sun.awt.image.ImageWatched;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
 *
 * 示例 1：
 * 输入：nums = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,4,2,7,5,3,8,6,9]
 *
 * 示例 2：
 * 输入：nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * 输出：[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *
 * 示例 3：
 * 输入：nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * 输出：[1,4,2,5,3,8,6,9,7,10,11]
 *
 * 示例 4：
 * 输入：nums = [[1,2,3,4,5,6]]
 * 输出：[1,2,3,4,5,6]
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i].length <= 10^5
 * 1 <= nums[i][j] <= 10^9
 * nums 中最多有 10^5 个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1424 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len = 0, pos = 0;
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            len += row.size();
            for (int j = 0; j < row.size(); j++) {
                List<Integer> list = map.getOrDefault(i + j, new LinkedList<>());
                list.add(0, row.get(j));
                map.putIfAbsent(i + j, list);
            }
        }
        int[] res = new int[len];
        for (int key : map.keySet()) {
            List<Integer> row = map.get(key);
            for (Integer x : row) {
                res[pos++] = x;
            }
        }
        return res;
    }
}