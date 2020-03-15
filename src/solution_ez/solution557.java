package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/15 21:55
 **/

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution557 {

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder(s);
        String[] arr = builder.reverse().toString().split(" ");
        String res = "";
        for (int i = arr.length - 1; i > 0; i--) {
            res += arr[i] + " ";
        }
        return res + arr[0];
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        solution557 s = new solution557();
        System.out.println(s.reverseWords(str));
    }
}
