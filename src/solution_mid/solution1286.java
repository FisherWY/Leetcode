package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/31 19:30
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 请你设计一个迭代器类，包括以下内容：
 * 一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
 * 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 * 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
 *
 * 示例：
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator
 * iterator.next(); // 返回 "ab"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "ac"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "bc"
 * iterator.hasNext(); // 返回 false
 *
 * 提示：
 * 1 <= combinationLength <= characters.length <= 15
 * 每组测试数据最多包含 10^4 次函数调用。
 * 题目保证每次调用函数 next 时都存在下一个字母组合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/iterator-for-combination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1286 {

    class CombinationIterator {

        private List<String> list;
        private int pos;

        public CombinationIterator(String characters, int combinationLength) {
            list = new ArrayList<>();
            dfs(characters, combinationLength, 0, "");
            pos = 0;
        }

        public String next() {
            return list.get(pos++);
        }

        public boolean hasNext() {
            return pos < list.size();
        }

        private void dfs(String s, int len, int index, String path) {
            if (path.length() == len) {
                list.add(path);
                return;
            }

            for (int i = index; i < s.length(); i++) {
                dfs(s, len, i + 1, path + s.charAt(i));
            }
        }
    }

    private CombinationIterator build(String s, int len) {
        return new CombinationIterator(s, len);
    }

    public static void main(String[] args) {
        solution1286 s = new solution1286();
        CombinationIterator iterator = s.build("abc", 2);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
