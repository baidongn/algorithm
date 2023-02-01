package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

;
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 981 👎 0

public class 二叉树的前序遍历 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的前序遍历().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            //前序遍历指的是 中间数字在前面（数组只存放当前节点）
            // 深度遍历 将中间的放入数组  再深层遍历左边 然后右边
            List<Integer> list = new ArrayList();

            preorder(root,list);

            return list;
        }

        //确定 传入  传出参数
        public void preorder(TreeNode root, List<Integer> list) {
            //终止条件
            if (root == null) {
                return;
            }

            //写单层遍历
            //中（当前节点）
            list.add(root.val);
            //左
            preorder(root.left, list);
            //右
            preorder(root.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}