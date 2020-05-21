package LCP;

/**
 * @Author Fisher
 * @Date 2020/5/21 21:30
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。
 * 小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 *
 * 示例 1：
 * 输入：command = "URR", obstacles = [], x = 3, y = 2
 * 输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 *
 * 示例 2：
 * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
 * 输出：false
 * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
 *
 * 示例 3：
 * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
 * 输出：true
 * 解释：到达终点后，再碰到障碍物也不影响返回结果。
 *  
 * 限制：
 * 2 <= command的长度 <= 1000
 * command由U，R构成，且至少有一个U，至少有一个R
 * 0 <= x <= 1e9, 0 <= y <= 1e9
 * 0 <= obstacles的长度 <= 1000
 * obstacles[i]不为原点或者终点
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/programmable-robot
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCP03 {

    class Solution {
        public boolean robot(String command, int[][] obstacles, int x, int y) {

            //指令集
            char[] commands = command.toCharArray();
            // 记录第一轮走过的所有点
            int[][] path = new int[commands.length][2];
            int xStep = 0, yStep = 0;
            for (int i = 0; i < commands.length; i++) {
                char c = commands[i];
                switch (c) {
                    case ('U'):
                        // 获取指令集对应的坐标
                        yStep += +1;
                        break;
                    case ('R'):
                        // 获取指令集对应的坐标
                        xStep += 1;
                        break;
                    default:
                        break;
                }
                path[i][1] = yStep;
                path[i][0] = xStep;
            }

            //判断是否会撞墙
            for (int[] obstacle : obstacles) {
                if (obstacle[0] >= x && obstacle[1] >= y) {
                    continue;
                }
                if (checkPoint(path, obstacle[0], obstacle[1], xStep, yStep)) {
                    return false;
                }
            }
            // 判断是否会到达终点
            return checkPoint(path, x, y, xStep, yStep);


        }

        public boolean checkPoint(int[][] paths, int x, int y, int xStep, int yStep) {
            // 其后每一轮的的路径都与第一轮路径相同，所以只要后面的路径中
            // x,y坐标值与第一轮所有点的路径上对应点的坐标有关
            // (x-x1)%xStep=0 (y-y1)%yStep = 0
            for (int[] path : paths) {
                if ((x - path[0]) % xStep == 0 && (y - path[1]) % yStep == 0 && (x - path[0]) / xStep == (y - path[1]) / yStep) {
                    return true;
                }
            }
            return false;
        }
    }

    // 不知道为啥，倒数第二个测试用例错了，但是测试用例太长了，没办法调试，真的不知道咋错的
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        // 将障碍物储存到一个set中
        Set<Integer> set = new HashSet<>();
        for (int[] arr : obstacles) {
            int position = (arr[0] << 10) + arr[1];
            set.add(position);
        }
        char lastCmd = 'a';
        int i = 0, len = command.length() , posX = 0, posY = 0;
        while (posX <= x && posY <= y) {
            lastCmd = command.charAt(i);
            if (lastCmd == 'U') { // Up
                posY++;
            } else {    // Right
                posX++;
            }
            // 终点检测
            if (posX == x && posY == y) {
                return true;
            }
            // 碰撞检测
            int position = (posX << 10) + posY;
            if (set.contains(position)) {
                return false;
            }
            i = (i + 1) % len;
        }
        return false;
    }

    public static void main(String[] args) {
        String command = "URR";
        int[][] obstacles = {

        };
        int x = 3, y = 2;
        LCP03 lcp03 = new LCP03();
        System.out.println(lcp03.robot(command, obstacles, x, y));
    }
}
