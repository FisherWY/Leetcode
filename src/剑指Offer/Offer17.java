package 剑指Offer;

public class Offer17 {
    public int[] printNumbers(int n) {
        int x = 10;
        for (int i = 0; i < n; i++) {
            x *= 10;
        }
        int[] res = new int[x - 1];
        for (int i = 0; i < x - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
