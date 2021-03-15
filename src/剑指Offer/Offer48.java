package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int old_pos = map.getOrDefault(c, -1);
            map.put(c, i);
            len = len < i - old_pos ? len + 1 : i - old_pos;
            max = Math.max(max, len);
        }
        return max;
    }
}
