package 剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class Offer61 {

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int x : nums) {
            if (x == 0) {
                continue;
            }
            if (set.contains(x)) {
                return false;
            }
            set.add(x);
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        return max - min < 5;
    }
}
