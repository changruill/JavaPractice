package learning;

public class ReverseKGroup {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 法一：非递归法
//    public static ListNode reverseKGroup(ListNode head, int k) {
//        /**
//         * 每k个节点单独划为一组进行处理
//         * 每组内进行一次链表反转
//         * 必须对ListNode.head进行修改
//         * 每组的第一个节点接下一组的最后一个节点
//         *
//         * example: 1-2-3-4-5-6-7-8-9-10-11, k=3
//         * res:     3-2-1-6-5-4-9-8-7-10-11
//         */
//        if (k == 1 || head == null || head.next == null) {return head;}
//
//        boolean have_changed_head = false;
//        int node_num = 0;
//        int length = 0;
//
//        ListNode current = head;
//        // group_head记录的是将要处理的每一组的第一个节点
//        ListNode group_head = head;
//        // pre_group_head记录的是上一组尚未处理next的最后一个节点
//        ListNode pre_group_head = null;
//        // next_group_head记录的是下一组尚未处理的第一个节点
//        ListNode next_group_head = null;
//
//        while (current != null) {
//            length++;
//            node_num++;
//
//            if (node_num % k == 0) {
//                next_group_head = current.next;
//                node_num = 0;
//                // 链表翻转算法
//                ListNode prev = group_head;
//                ListNode cur = group_head.next;
//
//                int i = 2;
//                while (cur != null && i <= k) {
//                    ListNode temp = cur.next;
//                    cur.next = prev;
//                    prev = cur;
//                    cur = temp;
//                    i++;
//                }
//                if (!have_changed_head) {
//                    head = prev;
//                    have_changed_head = true;
//                }
//                // 每组的第一个节点接下一组的最后一个节点
//                if (pre_group_head == null)
//                    pre_group_head = group_head;
//                else {
//                    pre_group_head.next = prev;
//                    pre_group_head = group_head;
//                }
//                group_head = next_group_head;
//                current = next_group_head;
//            } else
//                current = current.next;
//        }
//
//        // 处理不是整倍数剩下的节点
//        if (length < k)
//            return head;
//        else if (length % k == 0) {
//            pre_group_head.next = null;
//            return head;
//        }
//        pre_group_head.next = group_head;
//        return head;
//    }

    // 法二：递归法
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;
        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        // 满足条件，进行翻转
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if (next != null) {
                // head 为链表翻转后的尾节点
                // head 是这一组的尾节点或是后面链表的head
                head.next = reverseKGroup(next, k);
            }
            // prev 为链表翻转后的头结点
            return prev;
        } else {
            // 不满住翻转条件，直接返回 head 即可
            return head;
        }
    }

}
