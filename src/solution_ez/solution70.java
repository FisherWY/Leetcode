package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/9 22:10
 **/

import java.util.Scanner;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 *
 * 理解：到达第i阶方法有2个，从第i-1阶到达和第i-2阶到达，因此递推式为dp[i] = dp[i-1] + dp[i-2]
 *      到达第0阶和第一阶的方法只有1种，因此dp[0]和dp[1]均为1
 *      剩余台阶利用前面的递推式，使用for循环递推可得出
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution70 {

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        solution70 s = new solution70();
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            n = scanner.nextInt();
            System.out.println(s.climbStairs(n));
        } while (n >= 0);
        scanner.close();
    }
}
