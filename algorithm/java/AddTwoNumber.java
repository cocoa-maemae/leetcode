import java.util.*;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public void insert(int val) {
        ListNode end = new ListNode(val);
        ListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void printAll(ListNode head) {
        ListNode n = head;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}

public class AddTwoNumber {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits
     * are stored in reverse order and each of their nodes contain a single digit. Add the two
     * numbers and return it as a linked list. You may assume the two numbers do not contain any
     * leading zero, except the number 0 itself. Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0
     * -> 8 Explanation: 342 + 465 = 807.
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.insert(4);
        l1.insert(3);
        ListNode l2 = new ListNode(5);
        l2.insert(6);
        l2.insert(4);
        ListNode answer = addTwoNumbers(l1, l2);
        answer.printAll(answer);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int s = 0;
        while (l1 != null || l2 != null || s >= 10) {
            s /= 10;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(s % 10);
            cur = cur.next;
        }
        return head.next;
    }
}
