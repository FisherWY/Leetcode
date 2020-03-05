package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/5 22:08
 **/

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution415 {

    public String addStrings(String num1, String num2) {
        String res = "";
        int pos1 = num1.length() - 1, pos2 = num2.length() - 1;
        boolean carry = false;
        while (pos1 >= 0 && pos2 >= 0) {
            int append = 0;
            append += num1.charAt(pos1) - '0';
            append += num2.charAt(pos2) - '0';
            if (carry) {
                append += 1;
            }
            res = (append % 10) + res;
            if (append >= 10) {
                carry = true;
            } else {
                carry = false;
            }
            pos1--;
            pos2--;
        }
        while (pos1 >= 0) {
            if (carry) {
                int append = 1;
                append += num1.charAt(pos1) - '0';
                res = (append % 10) + res;
                if (append >= 10) {
                    carry = true;
                } else {
                    carry = false;
                }
                pos1--;
            } else {
                res = num1.substring(0, pos1 + 1) + res;
                break;
            }
        }
        while (pos2 >= 0) {
            if (carry) {
                int append = 1;
                append += num2.charAt(pos2) - '0';
                res = (append % 10) + res;
                if (append >= 10) {
                    carry = true;
                } else {
                    carry = false;
                }
                pos2--;
            } else {
                res = num2.substring(0, pos2 + 1) + res;
                break;
            }
        }
        if (carry) {
            res = "1" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "111";
        String s2 = "999";
        solution415 s = new solution415();
        System.out.println(s.addStrings(s1, s2));
    }
}
