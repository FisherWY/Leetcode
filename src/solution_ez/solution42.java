package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/4 21:44
 **/

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution42 {
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0, max_right = 0;
            // 向左找最高的柱子
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            // 向右找最高的柱子
            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            // 计算降水量
            res += Math.min(max_left, max_right) - height[i];
        }
        return res;
    }
}
