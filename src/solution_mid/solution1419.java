package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/3 21:53
 **/

/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。
 * 由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 *
 * 示例 1：
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 *
 * 示例 2：
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 *
 * 示例 3：
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 *
 * 示例 4：
 * 输入：croakOfFrogs = "croakcroa"
 * 输出：-1
 *
 * 提示：
 * 1 <= croakOfFrogs.length <= 10^5
 * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-frogs-croaking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int res = 0;
        for (char x : croakOfFrogs.toCharArray()) {
            if (x == 'c') {
                c++;
                if (k > 0) {
                    k--;
                } else {
                    res++;
                }
            } else if (x == 'r') {
                r++;
                c--;
            } else if (x == 'o') {
                o++;
                r--;
            } else if (x == 'a') {
                a++;
                o--;
            } else if (x == 'k') {
                k++;
                a--;
            }
            if (c < 0 || r < 0 || o < 0 || a < 0) {
                return -1;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "croakcroak";
        solution1419 s = new solution1419();
        System.out.println(s.minNumberOfFrogs(str));
    }
}
