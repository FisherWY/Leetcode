package 剑指Offer;

public class Offer67 {

    public int strToInt(String str) {
        char[] arr = str.trim().toCharArray();
        if (arr.length == 0) {
            return 0;
        }
        int res = 0, of = Integer.MAX_VALUE / 10, pos = 0, sign = 1;
        if (arr[pos] == '-') {
            sign = -1;
            pos++;
        } else if (arr[pos] == '+') {
            pos++;
        }
        while (pos < arr.length) {
            if (arr[pos] < '0' || arr[pos] > '9') {
                break;
            }
            // Int越界处理
            if (res > of || (res == of && arr[pos] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (arr[pos] - '0');
            pos++;
        }
        return sign * res;
    }
}
