package 剑指Offer;

public class Offer53_1 {
    public int search(int[] nums, int target) {
        int pos = fun(nums, target, 0, nums.length - 1);
        if (pos == -1) {
            return 0;
        }
        int left = pos, right = pos;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right <= nums.length - 1 && nums[right] == target) {
            right++;
        }
        return right - left - 1;
    }

    private int fun(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return fun(nums, target, mid + 1, right);
        } else {
            return fun(nums, target, left, mid - 1);
        }
    }
}
