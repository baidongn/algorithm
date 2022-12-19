package leetcode.editor.cn;

;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 👍 705 👎 0

public class 有效的字母异位词 {
    public static void main(String[] args) {
        Solution solution = new 有效的字母异位词().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            //定义一个数组 a-z 26（求出a的相对值开始）
            int[] record = new int[26];

            //遍历 +1
            for (int i = 0; i < s.length(); i++) {
                record[s.charAt(i) - 'a']++;
            }

            //遍历 -1
            for (int i = 0; i < t.length(); i++) {
                record[t.charAt(i) - 'a']--;
            }

            for (int i = 0; i < record.length; i++) {
                if (record[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}