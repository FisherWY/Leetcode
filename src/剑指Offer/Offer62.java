package 剑指Offer;

public class Offer62 {
    // 倒推法，最后一个剩下的元素下标一定为0
    public int lastRemaining(int n, int m) {
        int index = 0, length = 1;
        for (int i = 0; i < n - 1; i++) {
            index = (index + m) % (length + 1);
            length++;
        }
        return index;
    }
}
