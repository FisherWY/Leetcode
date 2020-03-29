package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/29 22:18
 **/

/**
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 * 示例 1：
 * 输入: "Hello"
 * 输出: "hello"
 *
 * 示例 2：
 * 输入: "here"
 * 输出: "here"
 *
 * 示例 3：
 * 输入: "LOVELY"
 * 输出: "lovely"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution709 {

    public String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x > 64 && x < 90) {
                x = Character.toLowerCase(x);
            }
            builder.append(x);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "Hello";
        solution709 s = new solution709();
        System.out.println(s.toLowerCase(str));
    }
}
