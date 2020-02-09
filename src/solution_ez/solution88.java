package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/9 23:08
 **/

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m - 1;
        int pos2 = n - 1;
        int pointer = nums1.length - 1;
        while (pos1 >= 0 && pos2 >= 0) {
            if (nums1[pos1] > nums2[pos2]) {
                nums1[pointer] = nums1[pos1];
                --pos1;
            } else {
                nums1[pointer] = nums2[pos2];
                --pos2;
            }
            --pointer;
        }
        while (pos2 >= 0) {
            nums1[pointer] = nums2[pos2];
            --pos2;
            --pointer;
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};

        solution88 s = new solution88();
        s.merge(nums1, 3, nums2, 3);
        for (int x : nums1) {
            System.out.print(x + " -> ");
        }
    }
}
