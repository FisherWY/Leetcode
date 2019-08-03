package solution21_30;

/**
 * @Author Fisher
 * @Date 2019/8/3 10:06
 **/

/**
 * Question28：实现strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution28 {
    public int strStr(String haystack, String needle) {
        int haystack_len = haystack.length();
        int needle_len = needle.length();
        if (needle_len == 0) {
            return 0;
        }
        if (haystack_len < needle_len) {
            return -1;
        }
        int haystack_pos = 0;
        while (haystack_pos < haystack_len) {
            int needle_pos = 0;
            while (haystack.charAt(haystack_pos+needle_pos) == needle.charAt(needle_pos)) {
                needle_pos++;
                if (needle_pos == needle_len) {
                    return haystack_pos;
                }
                if (haystack_pos + needle_pos > haystack_len) {
                    break;
                }
            }
            haystack_pos++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issippi";

        solution28 s28 = new solution28();
        System.out.println(s28.strStr(haystack, needle));
    }
}
