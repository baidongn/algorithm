package leetcode.editor.cn;;
//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 602 👎 0

public class 赎金信{
    public static void main(String[] args) {
        Solution solution = new 赎金信().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] records = new int[26];

        for (char c: ransomNote.toCharArray()) {
            records[c - 'a']++;
        }

        for (char c: magazine.toCharArray()) {
            records[c - 'a']--;
        }

        //先在少的里面放，如果少的里面有大于0，说明没有消除干净，返回flase
        for (char c: ransomNote.toCharArray()) {
            if(records[c-'a']>0){
                return false;
            }
        }
        return  true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}