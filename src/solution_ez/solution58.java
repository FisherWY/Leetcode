package solution_ez;

import java.util.Scanner;

/**
 * @Author Fisher
 * @Date 2020/2/7 22:52
 **/

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 *
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 理解：从字符串的尾部往前搜索，直到找到第一个不是空格的字符，记为该单词的end。
 *      再从end开始往前搜索，直到找到第一个空格字符或字符串的开头，记为该单词的start。
 *      end - start即为单词的长度
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class solution58 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            --end;
        }
        int start = end;
        while (start >=0 && s.charAt(start) != ' ') {
            --start;
        }
        return end - start;
    }

    public static void main(String[] args) {
        solution58 s = new solution58();
        Scanner scanner = new Scanner(System.in);
        String str = "";
        do {
            str = scanner.nextLine();
            System.out.println(s.lengthOfLastWord(str));
        } while (!str.equals("exit"));
        scanner.close();
    }
}
