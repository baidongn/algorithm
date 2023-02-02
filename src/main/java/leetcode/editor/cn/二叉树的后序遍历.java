package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

;
//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 973 👎 0

public class 二叉树的后序遍历 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的后序遍历().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList();

            postorder(root,list);

            return list;

        }

        public void postorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }

            //后序  左右中
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}