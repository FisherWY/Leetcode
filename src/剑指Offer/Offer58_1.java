package 剑指Offer;

public class Offer58_1 {

    public String reverseWords(String s) {
        s = s.replaceAll(" {2,}", " ");
        String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
