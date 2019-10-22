package com.sungjk.acmicpc.leetcode

import org.junit.Test

/**
 * Created by jeremy on 2019/10/22.
 */
class RemoveNthNodeFromEndOfList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null
        val length = this.getLength(head)
        val nth = length - n + 1
        return this.removeNth(head, nth, length, 1)
    }

    fun removeNth(head: ListNode?, target: Int, length: Int, current: Int): ListNode? {
        if (head == null || current > length) return null
        return if (target == current) {
            this.removeNth(head.next, target, length, current + 1)
        } else {
            ListNode(head.`val`).also {
                it.next = this.removeNth(head.next, target, length, current + 1)
            }
        }
    }

    private fun getLength(head: ListNode?): Int {
        if (head == null) return 0
        return 1 + this.getLength(head.next)
    }

    private fun traverse(head: ListNode?) {
        if (head == null) return
        print("${head.`val`}")
        if (head.next != null) {
            print("->")
            this.traverse(head.next)
        }
    }

    @Test
    fun test0() {
        this.traverse(null)
        println()
        this.traverse(removeNthFromEnd(ListNode(1), 1))
    }

    @Test
    fun test1() {
        // [1,2,3,4,5]
        val given = ListNode(1).also {
            it.next = ListNode(2).also {
                it.next = ListNode(3).also {
                    it.next = ListNode(4).also {
                        it.next = ListNode(5)
                    }
                }
            }
        }
        // [1,2,3,5]
        val expected = ListNode(1).also {
            it.next = ListNode(2).also {
                it.next = ListNode(3).also {
                    it.next = ListNode(5)
                }
            }
        }
        this.traverse(expected)
        println()
        this.traverse(removeNthFromEnd(given, 2))
    }
}