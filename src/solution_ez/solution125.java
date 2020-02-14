package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/14 22:25
 **/

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution125 {

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // 大写转小写
            if (65 <= arr[left] && arr[left] <= 90) {
                System.out.println(arr[left] + " : left to small");
                arr[left] += 32;
            }
            if (65 <= arr[right] && arr[right] <= 90) {
                System.out.println(arr[right] + " : right to small");
                arr[right] += 32;
            }
            // 其他字符跳过
            if (!isNumAndChar(arr[left])) {
                System.out.println(arr[left] + " : left jump");
                left++;
                continue;
            }
            if (!isNumAndChar(arr[right])) {
                System.out.println(arr[right] + " : right jump");
                right--;
                continue;
            }
            // 比较字符
            if (arr[left] == arr[right]) {
                System.out.println(arr[left] + " @ " + arr[right]);
                left++;
                right--;
            } else {
                System.out.println(arr[left] + " @ " + arr[right]);
                return false;
            }
        }
        return true;
    }

    private boolean isNumAndChar(char x) {
        if (Character.isSpaceChar(x) || (!Character.isDigit(x) && !Character.isAlphabetic(x))) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        String str = "0P";
        solution125 s = new solution125();
        if (s.isPalindrome(str)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
