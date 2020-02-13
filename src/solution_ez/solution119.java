package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/13 23:19
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 理解：错位相加，第n行的数组是由2个第n-1行数组错位相加而成，其中一组向后移动一位。
 * 例如：[1,3,3,1]是由[1,2,1]和[0,1,2,1]相加而得出
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution119 {
    public List<Integer> getRow(int rowIndex) {
        int[] result = new int[rowIndex + 1];
        result[0] = 1;
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i + 1; j > 0; j--) {
                result[j] += result[j - 1];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int x : result) {
            res.add(x);
        }
        return res;
    }

    public static void main(String[] args) {
        int rowIndex = 2;
        solution119 s = new solution119();
        List<Integer> res = s.getRow(rowIndex);
        for (Integer x : res) {
            System.out.print(x + " ");
        }
    }
}
