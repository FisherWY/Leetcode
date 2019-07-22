package solution11_20;

/**
 * @Author Fisher
 * @Date 2019/7/20 20:18
 **/

/**
 * Question14：最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution14 {

    public String longestCommonPrefix(String[] strs) {
        // 对于空字符串数组的处理
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (String x : strs) {
            int j = 0;
            while (j<ans.length() && j<x.length()) {
                if (ans.charAt(j) == x.charAt(j)) {
                    j++;
                    continue;
                } else {
                    break;
                }
            }
            ans = ans.substring(0, j);
            // 已经不存在最大公共子串，直接返回
            if (ans.equals("")) {
                return "";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        solution14 s14 = new solution14();
        String[] s = {"aa","a"};
        System.out.println(s14.longestCommonPrefix(s));
    }
}
