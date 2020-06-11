package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/10 20:38
 **/

/**
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * 如果当前数字为偶数，则将其除以 2 。
 * 如果当前数字为奇数，则将其加上 1 。
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 *
 * 示例 1：
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14 
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4 
 * Step 5) 4  是偶数，除 2 得到 2 
 * Step 6) 2  是偶数，除 2 得到 1 
 *
 * 示例 2：
 * 输入：s = "10"
 * 输出：1
 * 解释："10" 表示十进制数 2 。
 * Step 1) 2 是偶数，除 2 得到 1
 *
 * 示例 3：
 * 输入：s = "1"
 * 输出：0
 *  
 * 提示：
 * 1 <= s.length <= 500
 * s 由字符 '0' 或 '1' 组成。
 * s[0] == '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1404 {

    public int numSteps(String s) {
        StringBuilder builder = new StringBuilder(s);
        int pos = s.length() - 1, steps = 0;
        while (pos != 0) {
            if (builder.charAt(pos) == '0') {
                builder.deleteCharAt(pos);
                pos--;
            } else {
                builder.setCharAt(pos, '0');
                // 进位计算
                boolean carry = true;
                int ptr = pos - 1;
                while (ptr >= 0 && carry) {
                    if (builder.charAt(ptr) == '1') {
                        builder.setCharAt(ptr, '0');
                    } else {
                        builder.setCharAt(ptr, '1');
                        carry = false;
                    }
                    ptr--;
                }
                // 最高位进位
                if (carry) {
                    builder.insert(0, '1');
                }
                pos = builder.length() - 1;
            }
            steps++;
        }
        if (builder.charAt(pos) == '0') {
            return steps + 1;
        } else {
            return steps;
        }
    }

    public static void main(String[] args) {
        String str = "11000";
        solution1404 s = new solution1404();
        System.out.println(s.numSteps(str));
    }
}
