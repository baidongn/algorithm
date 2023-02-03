package leetcode.editor.cn;

;
//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 595 👎 0

public class 斐波那契数 {
    public static void main(String[] args) {
        Solution solution = new 斐波那契数().new Solution();

        int fib = solution.fib(10);
        System.out.println(fib);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n < 2) {
                return n;
            }

            //1. 确定dp数组的含义和下标
            int[] dp = new int[n + 1];  //比如n传5，但是包含0，所以有6个数

            //3. 初始化dp
            dp[0] = 0;
            dp[1] = 1;

            //4. 确定遍历顺序
            // 从前到后，到n截止
            for (int i = 2; i <= n; i++) {
                //2.确定递推公式
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];

        }

        //递归
        public int fib2(int n) {
            if (n < 2) {
                return n;
            }

            return fib2(n - 1) + fib2(n - 2);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}