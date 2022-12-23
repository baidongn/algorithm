package leetcode.editor.cn;

import java.util.HashMap;

;
//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// Related Topics 数组 哈希表 👍 714 👎 0

public class 四数相加II {
    public static void main(String[] args) {
        Solution solution = new 四数相加II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            //现将1，2相加，放入map（和为key，出现次数为value）
            //再遍历3，4，求和，再从map中找到，是否有相加等于0的

            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int num1 : nums1) {
                for (int num2 : nums2) {
                    int add1 = num1 + num2;
                    if (hashMap.containsKey(add1)) {
                        //这里不能用++
                        hashMap.put(add1, hashMap.get(add1) + 1);
                    } else {
                        hashMap.put(add1, 1);
                    }
                }
            }

            int total = 0;
            for (int num3 : nums3) {
                for (int num4 : nums4) {
                    int add2 = num3 + num4;
                    int add3 = -add2;
                    if (hashMap.containsKey(add3)) {
                        Integer num = hashMap.get(add3);
                        total = total + num;
                    }
                }
            }

            return total;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}