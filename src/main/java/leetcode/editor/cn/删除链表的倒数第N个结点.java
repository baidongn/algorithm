package leetcode.editor.cn;

;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 2336 👎 0

public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        Solution solution = new 删除链表的倒数第N个结点().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode listNode1 = solution.removeNthFromEnd(listNode, 10);
        System.out.println(listNode1);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //双指针法：构建虚节点，双指针指向虚节点，fast指针先提前走n+1，使得可以指向所找元素的钱已给，最后fast指向末尾，pre跨过连接
            ListNode dummyHead = new ListNode(0, head);
            ListNode fastIndex = dummyHead;
            ListNode slowIndex = dummyHead;

            n = n + 1; //提前走一步
            while (n-- > 0 && fastIndex != null) {
                fastIndex = fastIndex.next;
            }

            while (fastIndex != null) {
                fastIndex = fastIndex.next;
                slowIndex = slowIndex.next;
            }

            //fast已经指向末尾
            slowIndex.next = slowIndex.next.next;

            return dummyHead.next;


        }
    }

    public static class ListNode {
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
//leetcode submit region end(Prohibit modification and deletion)


}