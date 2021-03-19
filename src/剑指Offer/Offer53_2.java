package 剑指Offer;

public class Offer53_2 {

    public int missingNumber(int[] nums) {
        return fun(nums, 0, nums.length - 1);
    }

    private int fun(int[] nums, int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > mid) {
            return fun(nums, left, mid - 1);
        } else {
            return fun(nums, mid + 1, right);
        }
    }
}
