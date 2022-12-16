package leetcode.editor.cn;

;
//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
// Related Topics 哈希表 链表 双指针 👍 1881 👎 0

public class 环形链表II {
    public static void main(String[] args) {
        Solution solution = new 环形链表II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        //双指针  因为相对移动距离为1，只要环节点大于1，就一定会在第一圈相遇
        public ListNode detectCycle(ListNode head) {
            //定义快慢指针，fast指针走的快，并且不为null， 还在某一时刻追到（等于慢指针），会在第一圈追到则说明这是一个环
            ListNode fast = head;
            ListNode slow = head;
            //判空 确保数据不出错
            while (fast != null && fast.next != null) {
                //因为是同一起点开始，并且 走完一步之后 才进行判等
                fast = fast.next.next;
                slow = slow.next;

                //已经找到huan
                if (fast == slow) {
                    //寻找入口 （相遇点为index1）  慢指针从head开始，快指针从相遇点开始(每次走一步)，他们会在第一圈遇到相交， 相交点就是入口地址

                    ListNode indexfast = fast;
                    ListNode indexslow = head;
                    //不相等就继续走，相等就退出
                    while (indexfast != indexslow) {
                        //
                        indexfast = indexfast.next;
                        indexslow = indexslow.next;
                    }
                    return indexfast;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

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
}