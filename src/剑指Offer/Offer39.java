package 剑指Offer;

public class Offer39 {
    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int num = nums[0], count = 1;
        for (int x : nums) {
            if (x == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = x;
                count = 1;
            }
        }
        return num;
    }
}
