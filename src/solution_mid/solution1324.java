package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/14 17:11
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
 * 单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
 * 每个单词只能放在一列上，每一列中也只能有一个单词。
 *
 * 示例 1：
 * 输入：s = "HOW ARE YOU"
 * 输出：["HAY","ORO","WEU"]
 * 解释：每个单词都应该竖直打印。
 *  "HAY"
 *  "ORO"
 *  "WEU"
 *
 * 示例 2：
 * 输入：s = "TO BE OR NOT TO BE"
 * 输出：["TBONTB","OEROOE","   T"]
 * 解释：题目允许使用空格补位，但不允许输出末尾出现空格。
 * "TBONTB"
 * "OEROOE"
 * "   T"
 *
 * 示例 3：
 * 输入：s = "CONTEST IS COMING"
 * 输出：["CIC","OSO","N M","T I","E N","S G","T"]
 *
 * 提示：
 * 1 <= s.length <= 200
 * s 仅含大写英文字母。
 * 题目数据保证两个单词之间只有一个空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-words-vertically
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1324 {

    public List<String> printVertically(String s) {
        List<String> res=new ArrayList<>();
        String []words=s.split(" ");
        int max=0;  // 存储单词的最长长度
        for (String i:words)
            max= Math.max(max,i.length());
        for (int j = 0; j < max; j++) {
            String str="!"; //因为后面用到trim，但是不能去掉前面的空格，所以加个符号防去掉前面空格
            for (String word:words) {
                if (j + 1 > word.length()) {    //如果超出了单词长度就加空格
                    str+=" ";
                }
                else {  //没超就把字母写入
                    str+=word.charAt(j);
                }
            }
            res.add(str.trim().substring(1));//把新字符串一个个加到list
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "AA BBB C DDDD EEEEE F";
        solution1324 s = new solution1324();
        for (String x : s.printVertically(str)) {
            System.out.println(x);
        }
    }
}
