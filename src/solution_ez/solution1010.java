package solution_ez;

/**
 * @Author: Fisher
 * @Date: 2020/4/22 22:48
 */

/**
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 * 示例 1：
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 *
 * 示例 2：
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 *
 * 提示：
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1010 {

    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] seconds = new int[60];
        for (int x : time) {
            seconds[x % 60]++;
        }
        res += combine(seconds[30], 2);
        res += combine(seconds[0], 2);
        int left = 1, right = 59;
        while (left < right) {
            res += seconds[left++] * seconds[right--];
        }
        return res;
    }

    private int combine(int n, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int[] time = {30,20,150,100,40};
        solution1010 s = new solution1010();
        System.out.println(s.numPairsDivisibleBy60(time));
    }
}
