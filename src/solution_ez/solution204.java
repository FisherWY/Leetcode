package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/20 20:52
 **/

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class solution204 {

    public int countPrimes(int n) {
        boolean[] array = new boolean[n];
        Arrays.fill(array, true);
        for (int i = 2; i * i < n; i++) {
            if (array[i]) {
                for (int j = i * i; j < n; j += i) {
                    array[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (array[i]) {
                count++;
            }
        }
        return count - 2;
    }

    public static void main(String[] args) {
        solution204 s = new solution204();
        System.out.println(s.countPrimes(10));
    }
}
