package 剑指Offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Offer50 {

    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> item : map.entrySet()) {
            if (item.getValue()) {
                return item.getKey();
            }
        }
        return ' ';
    }
}
