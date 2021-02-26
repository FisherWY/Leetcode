package 剑指Offer;

public class Offer21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        int tmp;
        while (true) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            // System.out.println("left: " + left + " right: " + right);
            // swap
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}