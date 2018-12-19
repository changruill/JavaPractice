package learning;

public class MergeTwoLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, node;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val > l2.val) {
                head = l2;
                l2 = l2.next;
            } else {
                head = l1;
                l1 = l1.next;
            }
            node = head;
        }

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        if (l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }

        return head;
    }
}
