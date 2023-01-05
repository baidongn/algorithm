package leetcode.editor.cn;

;
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 0 <= m, n <= 3 * 10⁴ 
// 1 <= Node.val <= 10⁵ 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？ 
// Related Topics 哈希表 链表 双指针 👍 290 👎 0

public class 链表相交 {
    public static void main(String[] args) {
        Solution solution = new 链表相交().new Solution();
        ListNode node = new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5, null))));
        ListNode listNode = new ListNode(4, node);
        ListNode listNode1 = new ListNode(5, new ListNode(0, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5, null))))));
        ListNode intersectionNode = solution.getIntersectionNode(listNode, listNode1);
        System.out.println(intersectionNode.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //先计算出每个的长度，再把链表尾部对齐（ 这里同学们要注意，交点不是数值相等，而是指针相等。）

            int lengthA = 0;
            ListNode nodeA = headA;
            while (nodeA != null) {
                lengthA++;
                nodeA = nodeA.next;
            }

            int lengthB = 0;
            ListNode nodeB = headB;
            while (nodeB != null) {
                lengthB++;
                nodeB = nodeB.next;
            }

            //由于前面遍历后已经为null，所以重新赋值
            nodeA = headA;
            nodeB = headB;

            //交换 保证A 》B
            if (lengthB > lengthA) {
                int lengthtmp = lengthA;
                lengthA = lengthB;
                lengthB = lengthtmp;

                ListNode nodetmp = nodeA;
                nodeA = nodeB;
                nodeB = nodetmp;
            }

            //移动数组（A最大）
            int gap = lengthA - lengthB;
            while (gap > 0) {
                nodeA = nodeA.next;
                gap--;
            }
            while (nodeA != null) {
                if (nodeA == nodeB) {
                    return nodeA;
                }

                nodeA = nodeA.next;
                nodeB = nodeB.next;
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