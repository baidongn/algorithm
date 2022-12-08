package leetcode.editor.cn;

;
//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1479 👎 0

public class 长度最小的子数组 {
    public static void main(String[] args) {
        Solution solution = new 长度最小的子数组().new Solution();
        int[] nums = {1,2,3,4,5};
        int i = solution.minSubArrayLen1(11, nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minSubArrayLen1(int target, int[] nums) {

            int lenmin = Integer.MAX_VALUE;
            //暴力破解法  两个for循环 （一个起点位置，一个终点位置）
            for (int left = 0; left < nums.length; left++) {
                //因为每次都需要将区间数字的加起来
                int sum = 0;
                for (int right = left; right < nums.length; right++) {
                    sum += nums[right];
                    if (sum >= target) {
                        int len = right - left + 1;
                        lenmin = Math.min(lenmin, len);
                        //找到之後，求的是最短长度，所以没有必要向后查找了，直接退出，移动左指针
                        break;
                    }

                }
            }
            return lenmin == Integer.MAX_VALUE ? 0 : lenmin;


        }


        public int minSubArrayLen2(int target, int[] nums) {
            //采用滑动窗口的方法 用一个for循环当做窗口
            // 定义left变量，循环right变量
            // 每次遍历加nums[right]  符合要求减去nums[left]
            int left = 0;
            int sum = 0;
            int lenmin = Integer.MAX_VALUE;

            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    int len = right - left + 1;
                    //因为结果是要的最小的，所以这里只需要判断最小的；
                    //只要大于这个数。那么此时区间长度就是当前最小的，右边不需要移动，移动左边，进行下一次判断
                    //可能存在情况，右边新增的数字太大了，左边右移一位还是大于等于目标数，所以需要while判断
                    lenmin = lenmin < len ? lenmin : len;
                    sum -= nums[left];
                    left++;
                }
            }
            return lenmin == Integer.MAX_VALUE ? 0 : lenmin;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}