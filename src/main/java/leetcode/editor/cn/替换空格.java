package leetcode.editor.cn;

;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 386 👎 0

public class 替换空格 {
    public static void main(String[] args) {
        Solution solution = new 替换空格().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            /**
             * 1.先计算出有多少空格
             *  2. 构建新的数组
             *  3. 从后向前，替换(双指针)
             */
            char[] chars = s.toCharArray();
            int size = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    size++;
                }
            }
            if (size == 0) {
                return s;
            }
            int length = s.length() + size * 2;

            char[] charsNew = new char[length];
            int left = s.length() - 1;
            int right = length - 1;
            //将left指向的数字 复制给right，知道全部走完
            while (left >= 0) {
                if (chars[left] != ' ') {
                    charsNew[right] = chars[left];
                } else {
                    charsNew[right--] = '0';
                    charsNew[right--] = '2';
                    charsNew[right] = '%';
                }
                left--;
                right--;
            }
            return new String(charsNew);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}