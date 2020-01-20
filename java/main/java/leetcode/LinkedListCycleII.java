package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * Created by jeremy on 2020/01/20.
 */
public class LinkedListCycleII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> unique = new HashSet<>();
        ListNode cursor = head;
        while (cursor != null) {
            if (unique.contains(cursor)) {
                return cursor;
            }
            unique.add(cursor);
            cursor = cursor.next;
        }
        return null;
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
            Assert.assertEquals(l2.val, detectCycle(l1).val);
        }

        @Test
        public void test2() {
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(2);
            l1.next = l2;
            l2.next = l1;
            Assert.assertEquals(l1.val, detectCycle(l1).val);
        }

        @Test
        public void test3() {
            ListNode l1 = new ListNode(1);
            Assert.assertNull(detectCycle(l1));
        }

        @Test
        public void test4() {
            ListNode l0 = new ListNode(-1);
            ListNode l1 = new ListNode(-7);
            ListNode l2 = new ListNode(7);
            ListNode l3 = new ListNode(-4);
            ListNode l4 = new ListNode(19);
            ListNode l5 = new ListNode(6);
            ListNode l6 = new ListNode(-9);
            ListNode l7 = new ListNode(-5);
            ListNode l8 = new ListNode(-2);
            ListNode l9 = new ListNode(-5);
            l0.next = l1;
            l1.next = l2;
            l2.next = l3;
            l3.next = l4;
            l4.next = l5;
            l5.next = l6;
            l6.next = l7;
            l7.next = l8;
            l8.next = l9;
            l9.next = l6;
            Assert.assertEquals(l6.val, detectCycle(l0).val);
        }
    }
}
