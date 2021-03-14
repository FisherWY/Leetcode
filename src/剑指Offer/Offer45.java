package 剑指Offer;

import java.util.Arrays;

public class Offer45 {
    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder builder = new StringBuilder();
        for (String x : arr) {
            builder.append(x);
        }
        return builder.toString();
    }
}
