package solution11_20;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Fisher
 * @Date 2019/7/20 9:45
 **/

/**
 * Question13：罗马数字转整数
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution13 {

    public int romanToInt(String s) {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

        int sum = 0;

        // 不使用substring的情况下，速度要快上10ms，内存占用也更少
        char[] a = s.toCharArray();
        for (int i=0; i<a.length; i++) {
            if (i+1<a.length && romanMap.get(String.valueOf(a[i]))<romanMap.get(String.valueOf(a[i+1]))) {
                sum += romanMap.get(String.valueOf(a[i+1])) - romanMap.get(String.valueOf(a[i]));
                i++;
            } else {
                sum += romanMap.get(String.valueOf(a[i]));
            }
        }
//        for (int i=0; i<s.length(); i++) {
//            if (i+1<s.length() && romanMap.get(s.substring(i,i+1))<romanMap.get(s.substring(i+1,i+2))) {
//                sum += romanMap.get(s.substring(i+1,i+2)) - romanMap.get(s.substring(i,i+1));
//                i++;
//            } else {
//                sum += romanMap.get(s.substring(i,i+1));
//            }
//        }
        return sum;
    }

    public static void main(String[] args) {
        solution13 s13 = new solution13();
        String s = "MCMXCIV";
        System.out.println(s13.romanToInt(s));
    }
}
