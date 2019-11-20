package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/sort-list/
 * Created by jeremy on 2019/11/20.
 */
public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(right));
    }

    public static ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

//    public static ListNode sortList2(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        ListNode current = head;
//        while (current != null) {
//            if (head.val > current.val) {
//                ListNode temp = current;
//                current = head;
//                head = temp;
//            }
//            current = current.next;
//            sortList2(head.next);
//        }
//        return head;
//    }

    public static class UnitTest{
        @Test
        public void test1() {
            ListNode given = new ListNode(4);
            given.next = new ListNode(2);
            given.next.next = new ListNode(1);
            given.next.next.next = new ListNode(3);

            ListNode expect = new ListNode(1);
            expect.next = new ListNode(2);
            expect.next.next = new ListNode(3);
            expect.next.next.next = new ListNode(4);

            Assert.assertTrue(assertEquals(expect, sortList(given)));
        }
        @Test
        public void test2() {
            ListNode given = new ListNode(-1);
            given.next = new ListNode(5);
            given.next.next = new ListNode(3);
            given.next.next.next = new ListNode(4);
            given.next.next.next.next = new ListNode(0);

            ListNode expect = new ListNode(-1);
            expect.next = new ListNode(0);
            expect.next.next = new ListNode(3);
            expect.next.next.next = new ListNode(4);
            expect.next.next.next.next = new ListNode(5);

            Assert.assertTrue(assertEquals(expect, sortList(given)));
        }
    }

    public static boolean assertEquals(ListNode expected, ListNode given) {
        if (expected == null && given == null) return true;
        if (expected == null) return false;
        if (given == null) return false;
        return expected.val == given.val && assertEquals(expected.next, given.next);
    }

    public static void print(ListNode node) {
        if (node != null) {
            if (node.next == null) {
                System.out.print(node.val);
            } else {
                System.out.print(node.val + "->");
            }
            print(node.next);
        }
    }
}
