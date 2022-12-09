package leetcode.editor.cn;

;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2874 👎 0

public class 反转链表 {
    public static void main(String[] args) {
        Solution solution = new 反转链表().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            //只需要将head节点从头部放到尾部
            // 添加一个pre节点，指针反指 调换位置
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode tmp = cur.next; //保存下一个节点
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;

        }

        // 递归
        public ListNode reverseList2(ListNode head) {

            return reverse(null, head);

        }

        private ListNode reverse(ListNode prev, ListNode cur) {
            if (cur == null) {
                return prev;
            }

            ListNode tmp = cur.next;
            cur.next = prev;

            return reverse(cur, tmp);
        }


        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}