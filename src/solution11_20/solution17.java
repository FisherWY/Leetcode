package solution11_20;

/**
 * @Author Fisher
 * @Date 2019/7/24 11:06
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * Question17：电话号码的数字组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[][] keyboard = {
                {'!','@','#'},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        for (int i=0; i<digits.length(); i++) {
            // 将char转换为int，同时适应数组下标
            int n = digits.charAt(i) - '0' - 1;
            List<String> temp = new ArrayList<>();
            for (char x : keyboard[n]) {
                if (result.size() == 0) {
                    System.out.println("put: " + x);
                    String newStr = String.valueOf(x);
                    temp.add(newStr);
                } else {
                    for (String s : result) {
                        System.out.println(s + " + " + x);
                        String newStr = s + x;
                        temp.add(newStr);
                    }
                }
            }
            result.clear();
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "23";
        solution17 s17 = new solution17();
        List<String> res = s17.letterCombinations(s);
        for (String x : res) {
            System.out.println(x);
        }
    }
}
