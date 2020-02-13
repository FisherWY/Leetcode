package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/13 22:51
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        // 行数无效
        if (numRows <= 0) {
            return res;
        }
        // 初始化第一行
        List<Integer> line1 = new LinkedList<>();
        line1.add(0);
        line1.add(1);
        line1.add(0);
        res.add(line1);
        // 初始化第一行后面的
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(0);
            list.add(0);
            for (int j = 0; j < (i + 1); j++) {
                list.add(j+1, res.get(i-1).get(j) + res.get(i-1).get(j+1));
            }
            res.add(list);
        }
        // 去掉每一行中的零
        for (List<Integer> list : res) {
            list.remove(0);
            list.remove(list.size() - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int numRows = 10;
        solution118 s = new solution118();
        List<List<Integer>> res = s.generate(numRows);
        for (List<Integer> list : res) {
            for (Integer x : list) {
                System.out.print(x +  " ");
            }
            System.out.println();
        }
    }
}
