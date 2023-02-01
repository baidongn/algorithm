package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

;
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 1265 👎 0

public class 组合 {
    public static void main(String[] args) {
        Solution solution = new 组合().new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            //采用回溯算法

            backtracking(n, k, 1);
            return result;

        }

        /**
         * @param n  给出的数量
         * @param k  结果集个数
         * @param startIndex  下一个搜索数字
         */
        //结果集（二元数组）
        List<List<Integer>> result = new ArrayList<>();
        //单个集（一元数组,Link方便移除元素）
        LinkedList<Integer> path = new LinkedList<>();

        //回溯三部曲
        // 1. 确定返回值和传入参数   一般返回值为void
        public void backtracking(int n, int k, int startIndex) {
            //回溯三部曲
            // 2. 确定回溯终止条件
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }

            // 3. 单层递归
            // 3.1  for循环 （这里要有=，如果去掉 最后一个数字都会没有，加上 条件会自动跳过）
            for (int i = startIndex; i <= n; i++) {
                // 3.2 处理节点 (将该点加入path)
                path.add(i);
                // 3.3 递归
                backtracking(n, k, i + 1);
                // 3.4 指针回溯 （将path里加入的删除,继续回溯）
                path.removeLast();
            }


        }


        //回溯（剪枝）
        // 如果剩余元素不够就不再进行遍历（一般要+1，因为左闭和）

        /**
         *  path.size() ： 已经找的个数
         *  k-path.size() ：还需找的个数
         * 【x, n】的数组长度起码应该是k-path.size()才有继续搜索的可能，
         * 那么就有 n-x+1 = k-path.size()  ，
         *  解方程得 x = n+1 - (k-path.size()),
         *  而且这个x是可以作为起点往下搜的 也就是for(i = s; i<=x; i++) 这里的x是可以取到的
         **/
        public void backtracking2(int n, int k, int startIndex) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
                path.add(i);
                backtracking(n, k, i + 1);
                path.removeLast();
            }


        }


    }

//leetcode submit region end(Prohibit modification and deletion)


}