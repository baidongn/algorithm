package leetcode.editor.cn;

import java.util.Arrays;

;
//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 👍 674 👎 0

public class 有序数组的平方 {
    public static void main(String[] args) {
        Solution solution = new 有序数组的平方().new Solution();

        int[] nums = {-4, -1, 0, 3, 10};
        int[] squares = solution.sortedSquares2(nums);
        System.out.println(Arrays.toString(squares));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares1(int[] nums) {

            for (int i = 0; i < nums.length; i++) {
                nums[i] *= nums[i];
            }

            //排序
            sort(nums, 0, nums.length - 1);
            return nums;

        }

        public void sort(int[] arr, int left, int right) {
            if (right >= left) {
                //保存基数
                int basic = arr[left];
                //定义左右指针
                int i = left;
                int j = right;
                while (i < j) {        //左指针小于右指针
                    while (i < j && arr[j] > basic) {//操作右指针找到小于基数的下标
                        j--;
                    }
                    if (i < j) {
                        arr[i] = arr[j];    //将右指针对应小于基数的值放到左指针所指的位置
                        i++;                //左指针自加
                    }
                    while (i < j && arr[i] < basic) {//相反，找到大于基数的下标
                        i++;
                    }
                    if (i < j) {
                        arr[j] = arr[i];    //大于基数的值赋给右指针所指的位置
                        j--;                //右指针自减
                    }
                }
                arr[i] = basic;                //将基数放入到指针重合处
                sort(arr, left, i - 1);    //重复调用，对左半部分数组进行排序
                sort(arr, i + 1, right);    //对右半部分数组进行排序
            }
        }


        public int[] sortedSquares2(int[] nums) {

            //新建一个数组
            int[] res = new int[nums.length];
            //左右指针
            int left = 0, right = nums.length - 1;
            int size = nums.length - 1;

            //因为左右只会取一个，所以必须相等，保证取到最后一个
            while (left <= right) {
                if (nums[left] * nums[left] > nums[right] * nums[right]) {
                    res[size] = nums[left] * nums[left];
                    //移动指针
                    size--;
                    left++;
                } else {
                    res[size] = nums[right] * nums[right];
                    size--;
                    right--;

                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}