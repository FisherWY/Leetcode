package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/3 20:59
 **/

import java.util.LinkedList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 * 案例:
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * 注意事项:
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution401 {

    private int[] clock = {1,2,4,8,1,2,4,8,16,32};

    //表示时间，高四位表示小时，低六位表示分钟。从低位到高位的权值分别为：1、2、4、8、16、32、1、2、4、8
    private final int[] binaryTime = new int[10];

    private List<String> results = new LinkedList<>();

    public List<String> readBinaryWatch(int num) {
        backTrackTime(0, num);
        return results;
    }

    private void backTrackTime(int index, int num) {
        if (num <= 0) {
            //输出时间
            String time = convert(binaryTime);
            if (time != null) {
                results.add(time);
            }
            return;
        }

        if (index < binaryTime.length) {
            binaryTime[index] = 1;
            num--;
            backTrackTime(index + 1, num);
            binaryTime[index] = 0;
            num++;
            backTrackTime(index + 1, num);
        }

    }

    private String convert(int[] visited) {
        int hour = 0, min = 0;
        // 转换小时
        for (int i = 0; i < 4; i++) {
            if (visited[i] == 1) {
                hour += clock[i];
            }
        }
        // 转换分钟
        for (int i = 4; i < 10; i++) {
            if (visited[i] == 1) {
                min += clock[i];
            }
        }
        if (hour >= 12 || min >= 60) {
            return null;
        }
        if (min < 10) {
            return (hour + ":0" + min);
        } else {
            return (hour + ":" + min);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        solution401 s = new solution401();
        List<String> list = s.readBinaryWatch(n);
        for (String x : list) {
            System.out.println(x);
        }
    }
}
