package leetcode.editor.cn;

;
//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1644 👎 0

public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        Solution solution = new 两两交换链表中的节点().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            // 虚拟节点，然后判断后面一个  和两个不为空，位置进行交换，  当前位置移动到第二个，继续下一轮
            //当前节点为 head
            ListNode dummyNode = new ListNode(0, head);
            ListNode cur = dummyNode;
            while (cur.next != null && cur.next.next != null) {
                //存储 next
                ListNode tmp = cur.next.next.next;
                ListNode first = cur.next;

                //进行交换
                cur.next = cur.next.next;
                cur.next.next = first;
                first.next = tmp;

                //进行下一阶段判定
                cur = first;
            }

            return dummyNode.next;
        }

        //递归  添加虚拟节点  当前传入的为交换的第一个数
        public ListNode swapPairs2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode second = head.next;  //第二个
            ListNode listNode = swapPairs2(second.next); //第三个

            //排序
            head.next =listNode ;
            second.next = head;

            //返回当前的头结点 就是第二个
            return second;


        }





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

//leetcode submit region end(Prohibit modification and deletion)


}