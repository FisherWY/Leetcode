package 剑指Offer;

/**
 * 剑指Offer10-2：青蛙跳台阶问题
 */
public class Offer10_2 {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % 1000000007;
        }
        return res[n];
    }
}
