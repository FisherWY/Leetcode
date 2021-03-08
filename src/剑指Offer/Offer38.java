package 剑指Offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Offer38 {

    private StringBuilder builder;
    private char[] arr;
    private int[] visited;
    // private List<String> list;
    private Set<String> set;

    public String[] permutation(String s) {
        builder = new StringBuilder();
        arr = s.toCharArray();
        visited = new int[arr.length];
        // list = new LinkedList<>();
        set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            fun(i);
        }
        return set.toArray(new String[0]);
    }

    private void fun(int cur) {
        builder.append(arr[cur]);
        visited[cur]++;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == 0) {
                fun(i);
            }
        }
        if (builder.length() == arr.length) {
            // list.add(builder.toString());
            set.add(builder.toString());
        }
        // 回溯
        builder.deleteCharAt(builder.length() - 1);
        visited[cur]--;
    }
}
