package solution1_10;

/**
 * @Author Fisher
 * @Date 2019/7/18 9:57
 **/

/**
 * Question10：正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
enum Res {
    TRUE,
    FALSE
}

public class solution10 {

    private Res[][] result;

    private boolean isMatch(String s, String p) {
        // +1是为了防止递归调用时越界
        result = new Res[s.length()+1][p.length()+1];
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        // 这段暂时没发现其用处，注释之后正常运行
//        if (result[i][j] != null) {
//            return result[i][j] == Res.TRUE;
//        }
        boolean ans;
        // 匹配完成，判断s是否也匹配完成
        if (j == p.length()) {
            ans = (i == s.length());
        } else {    // 未匹配完成
            /*
             * 对字母的匹配
             * 匹配第一个字母，匹配条件：
             * 1. s下标未越界
             * 2. s的第i个字母与p的第j个字母相同
             * 3. p的第j个字母是'.'，即任意字符匹配
             */
            boolean first_match = (i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));

            /*
             * 对'*'的匹配
             * 检查pattern下一个字母是否是'*'，如果是则对s进行匹配，匹配条件：
             * 1. p下标未越界
             * 2. p的下一个字符是'*'
             */
            if (j+1<p.length() && p.charAt(j+1)=='*') {
                /*
                 * ans为true的条件：
                 * 1. pattern中'()*'的组合与s不匹配，则跳过'()*'直接到下一个pattern继续匹配，即"J+2"
                 * 2. pattern中的第一个字母与s匹配，s的下一个字母也与pattern中的第一个字母匹配
                 */
                ans = (dp(i, j+2, s, p) || first_match && dp(i+1, j, s, p));
            } else {
                // 没有'*'，正常的下一步匹配
                ans = (first_match && dp(i+1, j+1, s, p));
            }
        }
        // 填入当前匹配结果
        result[i][j] = ans ? Res.TRUE:Res.FALSE;
        // 回溯匹配结果
        return ans;
    }

    public boolean myisMatch(String s, String p) {
        // 空字符的处理
        if (s.length()==0 || p.length()==0) {
            return false;
        }
        // i表示s的下标，j表示p的下标
        int i = 0, j = 0;
        while (i<s.length() && j<p.length()) {
            // 对'.'的处理
            if (p.charAt(j)=='.') {
                System.out.println("compare1: " + s.charAt(i) + " and " + p.charAt(j));
                i++;
                j++;
                continue;
            }
            // 对'*'的处理
            if (j+1<p.length() && p.charAt(j+1)=='*') {
                // 跳过当前pattern以及随后的'*'
                if (s.charAt(i) != p.charAt(j)) {
                    j += 2;
                    continue;
                } else {
                    while (i+1<s.length() && s.charAt(i+1)==s.charAt(i)) {
                        i++;
                    }
                    j += 2;
                    continue;
                }
            }
            // 普通字符的处理
            if (s.charAt(i) == p.charAt(j)) {
                System.out.println("compare3: " + s.charAt(i) + " and " + p.charAt(j));
                i++;
                j++;
            } else {
                return false;
            }
        }
        System.out.println("i:" + i + " s:" + s.length());
        return (i+1)==s.length();
    }

    public static void main(String[] args) {
        solution10 s10 = new solution10();
        String s = "aa";
        String p = "a*";
        if (s10.isMatch(s,p)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
