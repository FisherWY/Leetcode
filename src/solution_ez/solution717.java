package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/29 22:28
 **/

/**
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 示例 1:
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 *
 * 示例 2:
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 *
 * 注意:
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution717 {

    public boolean isOneBitCharacter(int[] bits) {
        return helper(bits, 0);
    }

    private boolean helper(int[] bits, int pos) {
        // 最后越界
        if (pos >= bits.length) {
            return false;
        }
        // 到达最后1bit
        if (pos == bits.length - 1) {
            return bits[pos] == 0;
        }
        // 当前使用1bit
        if (bits[pos] == 0) {
            return helper(bits, pos + 1);
        }
        // 当前使用2bit
        if (bits[pos] == 1) {
            return helper(bits, pos + 2);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        solution717 s = new solution717();
        System.out.println(s.isOneBitCharacter(bits));
    }
}
