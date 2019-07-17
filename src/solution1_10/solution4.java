package solution1_10;

/**
 * @Author Fisher
 * @Date 2019/7/15 17:36
 **/

/**
 * Question4：寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 先对2个数组使用并归排序，再取数组中间的1个数或2个数，即为结果
 */
public class solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int[] num = new int[sum];
        int i=0,j=0,pos=0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] < nums2[j]) {
                num[pos] = nums1[i];
                i++;
            } else {
                num[pos] = nums2[j];
                j++;
            }
            pos++;
        }
        while (i<nums1.length) {
            num[pos] = nums1[i];
            i++;
            pos++;
        }
        while (j<nums2.length) {
            num[pos] = nums2[j];
            j++;
            pos++;
        }
        if (sum%2 == 0) {
            return (double)(num[sum/2] + num[sum/2-1])/2;
        } else {
            return num[sum/2];
        }
    }

    public static void main(String[] args) {
        solution4 s4 = new solution4();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println(s4.findMedianSortedArrays(nums1, nums2));
    }
}
