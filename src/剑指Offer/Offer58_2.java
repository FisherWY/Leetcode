package 剑指Offer;

public class Offer58_2 {

    public String reverseLeftWords(String s, int n) {
        n %= s.length();
        String res = s.substring(n, s.length()) + s.substring(0, n);
        return res;
    }
}
