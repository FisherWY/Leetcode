package solution1_10;

/**
 * @Author Fisher
 * @Date 2019/7/17 16:58
 **/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Question8: 字符串转换整数（atoi）
 *
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution8 {

    private int myNewAtoi(String str) {
        int pos = 0, len = str.length();
        int res = 0;
        boolean isPositive = true;
        if (len == 0) {
            return 0;
        }
        // 前置空格
        while (pos < len) {
            if (str.charAt(pos) == ' ') {
                pos++;
            } else {
                break;
            }
        }
        // 第一个字符是字母或负号
        if (pos < len && (str.charAt(pos) < '0' || str.charAt(pos) > '9')) {
            if (str.charAt(pos) == '-') {
                isPositive = false;
                pos++;
            } else if (str.charAt(pos) == '+') {
                isPositive = true;
                pos++;
            } else {
                return 0;
            }
        }
        // 解析数字
        while (pos < len) {
            if (str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
                int digit = str.charAt(pos) - '0';
                if (res > (Integer.MAX_VALUE - digit) / 10) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res *= 10;
                res += digit;
            } else {
                break;
            }
            pos++;
        }
        return isPositive ? res : -res;
    }

    public int myAtoi(String str) {
        // 去除尾部多余的空格
        str = str.trim();

        // 正则表达式提取数字
        String regex = "^[\\+\\-\\d]\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        // 生成结果
        String result = "";
        if (matcher.find()) {
            result = str.substring(matcher.start(), matcher.end());
        } else {
            return 0;
        }

        // 只有1个+号或者-号
        if (result.length() == 1 && ((result.charAt(0)=='+'||result.charAt(0)=='-'))) {
            return 0;
        }

        // 使用Integer类转化为int类型
        try {
            int r = Integer.parseInt(result);
            return r;
        } catch (Exception e) {
            // 如果超过int类型最大或最小值，则返回int类型最大值或最小值
            return result.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        String s = "-6147483648";
        solution8 s8 = new solution8();
        System.out.println(s8.myNewAtoi(s));
    }
}
