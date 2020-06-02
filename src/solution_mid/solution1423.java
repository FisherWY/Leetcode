package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/2 20:55
 **/

/**
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 * 示例 1：
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 *
 * 示例 2：
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 *
 * 示例 3：
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 *
 * 示例 4：
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 *
 * 示例 5：
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 *
 * 提示：
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1423 {

    /**
     * DFS: 超时方法
     * @param cardPoints
     * @param k
     * @return Integer
     */
    public int maxScore1(int[] cardPoints, int k) {
        return fun(cardPoints, k, 0, 0, cardPoints.length - 1, 0);
    }

    private int fun(int[] cardPoints, int k, int count, int left, int right, int cur) {
        if (count < k) {
            int leftSum = cardPoints[left] + fun(cardPoints, k, count + 1, left + 1, right, cur);
            int rightSum = cardPoints[right] + fun(cardPoints, k, count + 1, left, right - 1, cur);
            return cur + Math.max(leftSum, rightSum);
        } else {
            return 0;
        }
    }

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, pos = k, max = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        max = sum;
        for (int i = cardPoints.length - 1; pos > 0; i--) {
            sum = sum - cardPoints[--pos] + cardPoints[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;
        for (int x : cardPoints) {
            System.out.print(x + " ");
        }
        System.out.println("\nk = " + k);
        solution1423 s = new solution1423();
        System.out.println(s.maxScore(cardPoints, k));
    }
}
