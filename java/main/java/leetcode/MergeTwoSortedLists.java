package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Created by Jeremy on 12/01/2020.
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) {
            ListNode current = new ListNode(l2.val);
            current.next = mergeTwoLists(null, l2.next);
            return current;
        }
        if (l2 == null) {
            ListNode current = new ListNode(l1.val);
            current.next = mergeTwoLists(l1.next, null);
            return current;
        }

        if (l1.val > l2.val) {
            ListNode current = new ListNode(l2.val);
            current.next = mergeTwoLists(l1, l2.next);
            return current;
        } else {
            ListNode current = new ListNode(l1.val);
            current.next = mergeTwoLists(l1.next, l2);
            return current;
        }
    }

    public static boolean assertEquals(ListNode expected, ListNode given) {
        if (expected == null && given == null) return true;
        if (expected == null || given == null) return false;
        return expected.val == given.val && assertEquals(expected.next, given.next);
    }

    public static void print(ListNode l) {
        if (l == null) {
            System.out.println();
            return;
        }
        if (l.next == null) {
            System.out.print(l.val);
        } else {
            System.out.print(l.val + "->");
        }
        print(l.next);
    }

    public static class UnitTest {
        @Test
        public void test1() {
            ListNode l11 = new ListNode(1);
            ListNode l12 = new ListNode(2);
            ListNode l13 = new ListNode(4);
            l12.next = l13;
            l11.next = l12;
            ListNode l21 = new ListNode(1);
            ListNode l22 = new ListNode(3);
            ListNode l23 = new ListNode(4);
            l22.next = l23;
            l21.next = l22;
            ListNode e1 = new ListNode(1);
            ListNode e2 = new ListNode(1);
            ListNode e3 = new ListNode(2);
            ListNode e4 = new ListNode(3);
            ListNode e5 = new ListNode(4);
            ListNode e6 = new ListNode(4);
            e5.next = e6;
            e4.next = e5;
            e3.next = e4;
            e2.next = e3;
            e1.next = e2;
            Assert.assertTrue(assertEquals(e1, mergeTwoLists(l11, l21)));
        }
    }
}
