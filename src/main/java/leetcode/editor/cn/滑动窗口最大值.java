package leetcode.editor.cn;

import java.util.*;

;
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2092 👎 0

public class 滑动窗口最大值 {
    public static void main(String[] args) {
        Solution solution = new 滑动窗口最大值().new Solution();
        int[] nums = {1, 3, 1, 2, 0, 5};
        int[] ints = solution.maxSlidingWindow(nums, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 单调队列（队列只保存当前K个数据中 由大到小排列的数值 最大值每次只取第一个   利用排序思想进行加减操作）
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 构建一个队列，遍历数组，将数据放入队列（尾部入，头部出） 主要保证队列第一个放的是最大的元素
            // 移动数组，移除方法pop：如果头部元素相等，就移除该元素;否则没有变化
            //        添加方法push： 和头部元素相比，如果比头部大，那就所有元素出队列，该元素入队列
            //                      如果比头部小，那就放在后面，直接入队列
            //每次移动，通过front获取最大的元素
            List<Integer> numMax = new ArrayList<>();

            MyQueue myQueue = new MyQueue();

            // 现将前K个元素放入，进行初始化
            for (int i = 0; i < k; i++) {
                myQueue.push(nums[i]);
            }
            //取出最大值
            numMax.add(myQueue.front());


            for (int i = k; i < nums.length; i++) {
                int num1 = nums[i];
                int num2 = nums[i - k];

                //先取出 再放入
                myQueue.pop(num2);
                myQueue.push(num1);
                numMax.add(myQueue.front());
            }

            return numMax.stream().mapToInt(Integer::intValue).toArray();


        }
    }

    class MyQueue {
        // ArrayDeque 是 Java 集合中双端队列的数组实现，双端队列的链表实现（LinkedList）。
        Deque<Integer> deque = new LinkedList();


        //取出一个数
        public void pop(int value) {
            if (!deque.isEmpty() && deque.peek() == value) {
                deque.remove();
            }

        }

        //放入一个数
        public void push(int value) {

            //大于尾数，逐个比较，放入  保证由大到小
            while (!deque.isEmpty() && deque.getLast() < value) {
                deque.removeLast();
            }

            //小于等于顶数 放在后面
            deque.add(value);
        }

        //获取最大值
        public int front() {
            return deque.peek();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}