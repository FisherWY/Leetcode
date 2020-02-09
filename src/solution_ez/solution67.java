package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/8 22:10
 **/

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution67 {
    public String addBinary(String a, String b) {
        String s = "";
        int pos_a = a.length() - 1;
        int pos_b = b.length() - 1;
        // 保存进位
        int carry = 0;
        while (pos_a >= 0 || pos_b >= 0) {
            int res = carry;
            if (pos_a >= 0) {
                res += a.charAt(pos_a) - '0';
                --pos_a;
            }
            if (pos_b >= 0) {
                res += b.charAt(pos_b) - '0';
                --pos_b;
            }
            carry = res / 2;
            s = (res % 2) + s;
        }
        // 最高位进位
        if (carry == 1) {
            s = 1 + s;
        }
        return s;
    }

    /**
     * 十进制加法，使用了异或运算、与运算和位移操作
     * @param a 被加数
     * @param b 加数
     * @return 加法结果
     */
    private String fun(String a, String b) {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        int res = add(x, y);
        return String.valueOf(res);
    }

    private int add(int sum, int carry) {
        if (carry == 0) {
            return sum;
        }
        int x = sum ^ carry;
        int y = (sum & carry) << 1;
        return add(x, y);
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        solution67 s = new solution67();
        String res = s.addBinary(a,b);
        System.out.println(res);
    }
}
