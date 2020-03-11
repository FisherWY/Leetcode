package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/11 22:04
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 示例：
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *  
 * 注意：
 *
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution500 {

    char[][] keyboard = {
            {'q','w','e','r','t','y','u','i','o','p'},
            {'a','s','d','f','g','h','j','k','l'},
            {'z','x','c','v','b','n','m'}
    };

    public String[] findWords(String[] words) {
        String[] res = new String[words.length];
        int pos = 0;
        for (String x : words) {
            String tmp = x.toLowerCase();
            if (judge(tmp)) {
                res[pos++] = x;
            }
        }
        return Arrays.copyOf(res, pos);
    }

    private boolean judge(String s) {
        // 确定行
        char first = s.charAt(0);
        int line = 0;
        for (int i = 0; i < keyboard.length; i++) {
            boolean find = false;
            for (int j = 0; j < keyboard[i].length; j++) {
                if (keyboard[i][j] == first) {
                    line = i;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
        // 确定剩余的字符是否是同一行
        for (int i = 1; i < s.length(); i++) {
            boolean find = false;
            for (int j = 0; j < keyboard[line].length; j++) {
                if (keyboard[line][j] == s.charAt(i)) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        solution500 s = new solution500();
        String[] res = s.findWords(words);
        for (String x : res) {
            System.out.println(x);
        }
    }
}
