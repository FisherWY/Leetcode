package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/13 22:03
 **/

/**
 * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 *
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 *
 * 示例 :
 * 输入: "aba", "cdc"
 * 输出: 3
 * 解析: 最长特殊序列可为 "aba" (或 "cdc")
 *
 * 说明:
 * 两个字符串长度均小于100。
 * 字符串中的字符仅含有 'a'~'z'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution521 {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        int lenA = a.length();
        int lenB = b.length();
        return (lenA > lenB ? lenA : lenB);
    }

    public static void main(String[] args) {
        String str1 = "aba", str2 = "aba";
        solution521 s = new solution521();
        System.out.println(s.findLUSlength(str1, str2));
    }
}