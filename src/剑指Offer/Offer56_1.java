package 剑指Offer;

public class Offer56_1 {
    public int[] singleNumbers(int[] nums) {
        int[] res = {0,0};
        int x = 0, div = 1;
        for (int i : nums) {
            x ^= i;
        }
        while ((div & x) == 0) {
            div <<= 1;
        }
        for (int i : nums) {
            if ((i & div) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
