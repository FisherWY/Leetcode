package 剑指Offer;

public class Offer05 {

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * 直接用轮子的做法
     * @param s
     * @return replaced string
     */
    public String replaceSpace1(String s) {
        return s.replaceAll("\t", "%20");
    }
}
