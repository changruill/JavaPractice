package learning;

import java.util.Stack;

public class RemoveNthFromEnd {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 删除倒数第n个节点
        if (head == null || n <= 0) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        int length = 0;
        for (ListNode node = head; node != null; node = node.next, length++) {
            stack.push(node);
        }

        if (n > length) {
            return head;
        } else if (n == length) {
            return head.next;
        } else {
            // 前面至少还有一个节点
            for (int i = 1; i < n; i++) {
                stack.pop();
            }
            ListNode targetnode = stack.pop();
            stack.peek().next = targetnode.next;
        }

        return head;
    }
}
