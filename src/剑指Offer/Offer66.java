package 剑指Offer;

public class Offer66 {

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] res = new int[a.length];
        res[0] = 1;
        int tmp = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        for (int i = res.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
