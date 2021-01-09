package 剑指Offer;

/**
 * 剑指Offer10：斐波那契数列
 */
public class Offer10 {
    public int fib(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
