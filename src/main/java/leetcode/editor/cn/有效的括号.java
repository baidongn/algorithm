package leetcode.editor.cn;

import java.util.Stack;

;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3671 👎 0

public class 有效的括号 {
    public static void main(String[] args) {
        Solution solution = new 有效的括号().new Solution();
        boolean valid1 = solution.isValid1("({[]})");
        System.out.println(valid1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            char c;
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                //匹配到左括号，存入右括号
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                }else if (c == '[') {
                    stack.push(']');
                }else if (stack.isEmpty()|| stack.peek()!=c){ //必须放在前面，防止】  空里面peek报错
                    return false;
                }else if (c == stack.peek()){
                     stack.pop();
                }else {
                    return false;
                }
            }

            return stack.isEmpty();


        }


        public boolean isValid1(String s) {
            int length = s.length() / 2;
            for (int i = 0; i < length; i++) {
                s = s.replace("()", "").replace("{}", "").replace("[]", "");
            }

            return s.length() == 0;
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)