package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class Offer57_2 {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            int res = fun(target, 0, i);
            if (res != -1) {
                List<Integer> tmp = new ArrayList<>(res - i + 1);
                for (int j = i; j<= res; j++) {
                    tmp.add(j);
                }
                list.add(tmp);
            }
        }
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tmp = list.get(i);
            arr[i] = tmp.stream().mapToInt(Integer::intValue).toArray();
        }
        return arr;
    }

    private int fun(int target, int cur, int num) {
        int sum = cur + num;
        if (sum == target) {
            return num;
        } else if (sum > target) {
            return -1;
        } else {
            return fun(target, sum, num + 1);
        }
    }
}
