package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/4 21:46
 **/

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution412 {

    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        for (int i = 1; i <= n; i++) {
            String s = "";
            for (Integer x : map.keySet()) {
                if (i % x == 0) {
                    s += map.get(x);
                }
            }
            if (s.length() == 0) {
                s += String.valueOf(i);
            }
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 15;
        solution412 s = new solution412();
        List<String> res = s.fizzBuzz(n);
        for (String x : res) {
            System.out.println(x);
        }
    }
}
