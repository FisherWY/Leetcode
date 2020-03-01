package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/1 21:26
 **/

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        int[] alphabet = new int[128];
        for (char x : mag) {
            alphabet[x]++;
        }
        for (char x : ran) {
            --alphabet[x];
            if (alphabet[x] < 0) {
                return false;
            }
        }
        return true;
    }
}
