package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/19 21:59
 **/

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution202 {

    private int fun(int n) {
        int sum = 0;
        while (n > 0) {
            int add = n % 10;
            sum += Math.pow(add, 2);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int prev = n, curr = n;
        do {
            prev = fun(prev);
            curr = fun(curr);
            curr = fun(curr);
        } while (prev != curr);
        return curr == 1;
    }

    public static void main(String[] args) {
        solution202 s = new solution202();
        if (s.isHappy(19)) {
            System.out.println("Happy");
        } else {
            System.out.println("Not Happy");
        }
    }
}
