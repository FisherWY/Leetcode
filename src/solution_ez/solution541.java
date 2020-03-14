package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/14 22:04
 **/

/**
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 * 要求:
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution541 {

    public String reverseStr(String s, int k) {
        String res = "";
        int len = s.length(), pos = 0;
        while (pos + 2 * k < len) {
            StringBuilder builder = new StringBuilder(s.substring(pos, pos + k));
            res += builder.reverse().toString();
            res += s.substring(pos + k, pos + 2 * k);
            pos += 2 * k;
        }
        if (pos + k >= len) {
            StringBuilder builder = new StringBuilder(s.substring(pos, len));
            res += builder.reverse().toString();
        }
        if (pos + k < len && pos + 2 * k >= len) {
            StringBuilder builder = new StringBuilder(s.substring(pos, pos + k));
            res += builder.reverse().toString();
            res += s.substring(pos + k, len);
        }
        return res;
    }

    private String fun(String s, int k) {
        int len = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            int left = i, right = Math.min(i + k - 1, len - 1);
            while (left < right) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 2;
        solution541 s = new solution541();
        System.out.println(s.fun(str, k));
    }
}
