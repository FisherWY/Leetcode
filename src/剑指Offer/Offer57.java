package 剑指Offer;

public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                break;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        res[0] = nums[left];
        res[1] = nums[right];
        return res;
    }
}
