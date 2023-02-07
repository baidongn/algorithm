package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

;
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1624 👎 0

public class 分割等和子集 {
    public static void main(String[] args) {
        Solution solution = new 分割等和子集().new Solution();
        int[] nums = {1, 5, 11, 5};
        boolean status = solution.canPartition(nums);
        System.out.println(status);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            /**
             * 转为01背包问题（滚动数组）
             * 重量为元素的值，价值也为元素的值
             * 背包重量为sum/2
             *
             * 这道题默认有个总和一半数在数组中；
             */

            int sum = 0;

            for (int i : nums) {
                sum += i;
            }
            int target = sum / 2;

            //奇数不可分
            if (sum % 2 != 0) {
                return false;
            }
            //容量为j的背包
            int[] dp = new int[target+1];

            //初始化
            dp[0] = 0;

            for (int i = 0; i < nums.length; i++) { //物品
                // 背包容积大于等于 放入物品容积
                for (int j = target; j >= nums[i]; j--) {  //背包

                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);


                }

            }


            return dp[target] == target;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}