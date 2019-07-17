package solution1_10;

/**
 * @Author Fisher
 * @Date 2019/7/17 10:02
 **/

import java.util.ArrayList;

/**
 * Question6: Z 字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution6 {

    public String convert(String s, int numRows) {
        // Init ArrayList
        ArrayList[] lists = new ArrayList[numRows];
        for (int i=0; i<lists.length; i++) {
            lists[i] = new ArrayList();
        }
        // no为行数
        int no = 0;
        // 决定行数是递增或递减
        boolean flag = false;
        for (int i=0; i<s.length(); i++) {
            System.out.println("no:" + no);
            lists[no].add(s.charAt(i));
            if (no==0 || no==numRows-1) {
                flag = !flag;
            }
            // 如果只有一行，则不进行行数的变化
            if (numRows != 1) {
                no += flag ? 1 : -1;
            }
        }

        // 按顺序生成结果字符串
        String result = "";
        for (ArrayList item: lists) {
            for (int j=0; j<item.size(); j++) {
                result = result + item.get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        solution6 s6 = new solution6();
        String s = "AB";
        System.out.println(s6.convert(s, 1));
    }
}
