package 剑指Offer;

import java.util.Arrays;

public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
