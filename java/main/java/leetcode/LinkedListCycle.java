package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Created by jeremy on 2020/01/20.
 */
public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        if (head.next == head) return true;
        ListNode nextNode = head.next;
        head.next = head;
        return hasCycle(nextNode);
    }

    public static class UnitTest {
        @Test
        public void test1() {
            ListNode l1 = new ListNode(3);
            ListNode l2 = new ListNode(2);
            ListNode l3 = new ListNode(0);
            ListNode l4 = new ListNode(-4);
            l1.next = l2;
            l2.next = l3;
            l3.next = l4;
            l4.next = l2;
            Assert.assertTrue(hasCycle(l1));
        }

        @Test
        public void test2() {
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(2);
            l1.next = l2;
            l2.next = l1;
            Assert.assertTrue(hasCycle(l1));
        }

        @Test
        public void test3() {
            ListNode l1 = new ListNode(1);
            Assert.assertFalse(hasCycle(l1));
        }
    }
}
