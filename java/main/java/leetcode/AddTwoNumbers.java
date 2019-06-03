package leetcode;

/**
 * Created by jeremy on 2019-06-03.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int acc) {
        if (l1 == null && l2 == null) {
            if (acc == 0) return null;
            ListNode nextNode = new ListNode(acc);
            nextNode.next = null;
            return nextNode;
        }
        if (l1 == null) {
            if (acc == 0) return l2;
            int added = l2.val + acc;
            ListNode nextNode = new ListNode(added % 10);
            nextNode.next = addTwoNumbers(null, l2.next, added / 10);
            return nextNode;
        } else if (l2 == null) {
            if (acc == 0) return l1;
            int added = l1.val + acc;
            ListNode nextNode = new ListNode(added % 10);
            nextNode.next = addTwoNumbers(null, l1.next, added / 10);
            return nextNode;
        }

        int added = l1.val + l2.val + acc;
        ListNode nextNode = new ListNode(added % 10);
        nextNode.next = addTwoNumbers(l1.next, l2.next, added / 10);
        return nextNode;
    }
}
