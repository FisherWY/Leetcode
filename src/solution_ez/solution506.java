package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/12 21:38
 **/

import java.util.*;

/**
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
 * 前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 *
 * 提示:
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution506 {

    private String[] medal = {"Gold Medal", "Silver Medal", "Bronze Medal"};

    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
        // 决定金银铜
        for (int i = 0; i < 3 && i < nums.length; i++) {
            res[map.get(nums[i])] = medal[i];
        }
        // 剩余名次
        for (int i = 3; i < nums.length; i++) {
            res[map.get(nums[i])] = String.valueOf(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        solution506 s = new solution506();
        String[] res = s.findRelativeRanks(nums);
        for (String x : res) {
            System.out.println(x);
        }
    }
}
