package 剑指Offer;

/**
 * 剑指Offer14-1：剪绳子
 * 涉及到数学分析，直接看题解吧
 */
public class Offer14_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
