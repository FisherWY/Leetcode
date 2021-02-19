package 剑指Offer;

public class Offer20 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        s = s.trim();
        try {
            double tmp = Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }

        char c = s.charAt(s.length() - 1);
        return (c >= '0' && c <= '9') || c == '.';
    }
}
