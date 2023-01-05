package leetcode.editor.cn;

;
//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 397 👎 0

public class 反转字符串II {
    public static void main(String[] args) {
        Solution solution = new 反转字符串II().new Solution();

        String s = solution.reverseStr("abcdefg", 2);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            /**
             * 每2k个一取，然后翻转前K个（0，2k。。。）
             * 相当于每次取头元素，
             * 判断每次头元素+k，如果大于则说明是最后结尾处，小于k，就需要全部进行翻转
             */
            StringBuilder sb = new StringBuilder(s);

            for (int i = 0; i < sb.length(); i += (2 * k)) {
                //说明前K个全部需要翻转
                if (i + k <= s.length()) {
                    reserveString(sb, i, i + k - 1);
                } else {
                    //剩余k，全部翻转
                    reserveString(sb, i, s.length() - 1);
                }
            }

            return sb.toString();
        }

        public void reserveString(StringBuilder sb, int begin, int stop) {

            while (begin < stop) {
                char tmp = sb.charAt(begin);
                sb.setCharAt(begin, sb.charAt(stop));
                sb.setCharAt(stop, tmp);
                begin++;
                stop--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}