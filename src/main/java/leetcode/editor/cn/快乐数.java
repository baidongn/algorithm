package leetcode.editor.cn;

import java.util.HashSet;

;
//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 哈希表 数学 双指针 👍 1162 👎 0

public class 快乐数 {
    public static void main(String[] args) {
        Solution solution = new 快乐数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            //循环下去一定会有重复的数字和出现，这个时候就说明 这个数不是快乐数；所以我们需要将这些数存储在set，然后判断有没有
            HashSet<Object> numset = new HashSet<>();

            // 循环条件
            while (n != 1 && !numset.contains(n)) {
                //从第一次开始就将和加入 set，然后就会计算，while判断有没有，再接着加入set，如此循环(如果后面加入，下次判断，里面肯定会有)
                numset.add(n);

                //每一次的和就是下一次的参数
                n = getSum(n);
            }

            //退出循环 可能是1 或者 已经包含但不是1
            return n == 1;

        }


        // 计算和
        private int getSum(int n) {
            int sum = 0;
            int i = 0;
            while (n > 0) {
                //单个数字 取余
                i = n % 10;
                sum += i * i;
                n = n / 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}