package 剑指Offer;

public class Offer56_2 {

    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += x & 1;
                x >>>= 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            count[i] %= 3;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= count[31 - i];
        }
        return res;
    }
}
