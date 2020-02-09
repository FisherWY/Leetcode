package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/8 23:39
 **/

import java.util.Scanner;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution69 {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        } else {
            return fun(x, 1, x);
        }
    }

    private int fun(int x, int left, int right) {
        int mid = (left + right) / 2;
        int res = x / mid;
        if (res == mid || (left + 1) == right) {
            return mid;
        } else if (res < mid) {
            return fun(x, left, mid);
        } else {
            return fun(x, mid, right);
        }
    }

    public static void main(String[] args) {
        solution69 s = new solution69();
        Scanner scanner = new Scanner(System.in);
        int x;
        do {
            x = scanner.nextInt();
            System.out.println(s.mySqrt(x));
        } while (x > 1);
        scanner.close();
    }
}
