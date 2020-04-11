package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/11 21:28
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 *
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution888 {

    /**
     * 设A有sumA糖果，B有sumB糖果
     * A要给B: x 个糖果，B要给A: y 个糖果
     * 可列出等式: sumA + y - x = sumB + x - y;
     * 解得: x = y + (sumA - sumB) / 2
     * x 取其中一个解返回即可
     * @param A A的糖果
     * @param B B的糖果
     * @return int[]
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0, delta = 0;
        Set<Integer> setB = new HashSet<>();
        for (int x : A) {
            sumA += x;
        }
        for (int x : B) {
            sumB += x;
            setB.add(x);
        }
        delta = (sumB - sumA) / 2;

        for (int x : A) {
            if (setB.contains(x + delta)) {
                return new int[]{x, x + delta};
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        solution888 s = new solution888();
        int[] A = {1,1};
        int[] B = {2,2};
        int[] res = s.fairCandySwap(A, B);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
