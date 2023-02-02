package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1910 👎 0

public class 子集 {
    public static void main(String[] args) {
        Solution solution = new 子集().new Solution();
        int[] nums = {0};
        solution.subsets(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            backtracking(nums, 0);
            return result;
        }

        // 结果集合单个集合
        List<List<Integer>> result = new ArrayList<>();
        LinkedList path = new LinkedList<Integer>();


        public void backtracking(int[] nums, int startIndex) {
            result.add(new ArrayList<>(path));  // 收集子集，要放在终止添加的上面，否则会漏掉自己

            // 确定终止条件
            if (startIndex >= nums.length) {
                return;
            }

            // 因为不是排序，无顺序要求，所以不需要从0开始
            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
//                result.add(new ArrayList<>(path));  不能加在这里，会漏掉一开始的 空集合！！！
                backtracking(nums, i + 1);
                path.removeLast();
            }


        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}