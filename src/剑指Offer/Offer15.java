package 剑指Offer;

/**
 * 剑指Offer15：二进制中1的个数
 */
public class Offer15 {

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }
}
