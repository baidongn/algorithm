package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2385 👎 0

public class 全排列 {
    public static void main(String[] args) {
        Solution solution = new 全排列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            backtracking(nums);
            return result;

        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used;//判断 该下标数字是否被使用过,用数组方便

        public void backtracking(int[] nums) {
            // 延迟到下一层递归进行放入，不用判断特使情况 更加规范化
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            // 因为有顺序，所以需要每一层重复取，从0开始
            for (int i = 0; i < nums.length; i++) {
                // 判断 如果重复了就跳过
                if (used[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                backtracking(nums);
                path.removeLast();
                used[i] = false;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}