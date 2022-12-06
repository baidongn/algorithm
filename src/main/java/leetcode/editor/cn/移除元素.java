 package leetcode.editor.cn;;
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 
//nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,2,2,3,0,4,2], val = 2
//输出：5, nums = [0,1,4,0,3]
//解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
//的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
// Related Topics 数组 双指针 👍 1576 👎 0

public class 移除元素 {
    public static void main(String[] args) {
       int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        Solution solution = new 移除元素().new Solution();
        int i = solution.removeElement2(nums, val);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement1(int[] nums, int val) {
            //暴力破解法--两层for循环
            int size = nums.length;
            for (int i = 0; i < size; i++) {
                if (nums[i] == val) {
                    for (int j = i + 1; j < size; j++) {
                        nums[j - 1] = nums[j];
                    }
                    size--;
                    i--;
                }
            }
            return size;
        }

        public int removeElement2(int[] nums, int val) {
            //双指针（一个快指针：遍历寻找新数组中的元素    一个慢指针：新数组中的元素）
            int slowIndex = 0;
            for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
                //如果遇到了就跳过,  否则就将快指针++  将值付给慢指针  然后慢指针++
                if (nums[fastIndex]!=val) {
                    nums[slowIndex] = nums[fastIndex];
                    slowIndex++;
                }
            }

            //由于slowIndex是从0开始的，每次执行完都+1（多了一位），所以直接将此值返回
            return slowIndex;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}