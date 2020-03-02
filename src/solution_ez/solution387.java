package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/2 21:48
 **/

import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *  
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution387 {

    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        boolean[] unique = new boolean[26];
        Arrays.fill(alphabet, -1);
        Arrays.fill(unique, true);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (alphabet[index] != -1) {
                unique[index] = false;
            } else {
                alphabet[index] = i;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < unique.length; i++) {
            if (unique[i] && alphabet[i] != -1) {
                res = (res < alphabet[i] ? res : alphabet[i]);
            }
        }
        return (res == Integer.MAX_VALUE ? -1 : res);
    }

    public static void main(String[] args) {
        String str = "leetcode";
        solution387 s = new solution387();
        System.out.println(s.firstUniqChar(str));
    }
}
