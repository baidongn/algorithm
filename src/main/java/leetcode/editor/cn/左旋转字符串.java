package leetcode.editor.cn;

;
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
//
// Related Topics 数学 双指针 字符串 👍 334 👎 0

public class 左旋转字符串 {
    public static void main(String[] args) {
        Solution solution = new 左旋转字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            // 先旋转左边
            // 再旋转右边
            // 再全部旋转
            StringBuilder stringBuilder = new StringBuilder(s);
            reserveString(stringBuilder,0,n-1);
            reserveString(stringBuilder,n,s.length()-1);
            stringBuilder.reverse();
            return stringBuilder.toString();
        }

        public void reserveString(StringBuilder sb, int begin, int end) {
            //首尾交换

            while (begin < end){
                char tmp = sb.charAt(begin);
                sb.setCharAt(begin, sb.charAt(end));
                sb.setCharAt(end,tmp);
                begin++;
                end--;
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}