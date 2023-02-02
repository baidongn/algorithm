package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1367 👎 0

public class 分割回文串 {
    public static void main(String[] args) {
        Solution solution = new 分割回文串().new Solution();
        List<List<String>> aab = solution.partition("aab");
        System.out.println(aab);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {

            backtracking(s, 0);
            return result;

        }

        // 单个集合 和 结果集
        LinkedList<String> path = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();

        // 1. 确定入参和返回参数
        public void backtracking(String s, int startIndex) {
            // 2. 确定停止条件
            if (startIndex >= s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }

            // 3. 回溯
            for (int i = startIndex; i < s.length(); i++) {

                // 3.1 处理回溯
                if (isPalindrome(s, startIndex, i)) {
                    path.add(s.substring(startIndex, i+1));
                } else {
                    continue;
                }

                // 3.2 递归
                backtracking(s, i + 1);

                // 回溯指针
                path.removeLast();


            }


        }


        // 判断是否是回文
        public boolean isPalindrome(String s, int startIndex, int lastIndex) {
            String s1 = s.substring(startIndex, lastIndex+1);
            String s2 = new StringBuffer(s1).reverse().toString();
            return s1.equals(s2);

        }


        //判断是否是回文串
        private boolean isPalindrome2(String s, int startIndex, int end) {
            for (int i = startIndex, j = end; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }


    }


//leetcode submit region end(Prohibit modification and deletion)


}