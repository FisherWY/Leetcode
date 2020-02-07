package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/7 11:53
 **/

import java.util.Scanner;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 *
 * 解释：这是一个基本样例。
 *
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；
 *      类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 我对题目的理解：按照第n-1种情况给出的字符串，将其中连续出现的数字进行统计，统计结果的形式为：重复次数+重复的数字.
 *               比如说11统计为21；21理解为1个2加1个1，因此是1211；以此类推
 */
public class solution38 {
    public String countAndSay(int n) {
        if (n < 1) {
            return "Invalid input";
        }
        if (n == 1) {
            return "1";
        }
        // n为上一种情况时的结果
        String s = countAndSay(n - 1);
        // 对上一种情况的解析
        int pos = 0;
        String res = "";
        while (pos < s.length()) {
            // 统计某一数字的重复次数
            char start = s.charAt(pos);
            int times = 1;
            while ((pos + times) < s.length() && s.charAt(pos + times) == start) {
                times++;
            }
            res += String.valueOf(times);
            res += String.valueOf(start);
            pos += times;
        }
        return res;
    }

    public static void main(String[] args) {
        solution38 s = new solution38();
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            n = scanner.nextInt();
            String res = s.countAndSay(n);
            System.out.println(res);
        } while (n != -1);
    }
}
