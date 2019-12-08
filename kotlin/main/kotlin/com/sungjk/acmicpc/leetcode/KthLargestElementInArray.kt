package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Created by Jeremy on 08/12/2019.
 */
class KthLargestElementInArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return nums.sortedDescending().drop(k - 1).first()
    }

    @Test
    fun test0() {
        Assert.assertEquals(42, findKthLargest(intArrayOf(42), 1))
    }

    @Test
    fun test1() {
        Assert.assertEquals(5, findKthLargest(intArrayOf(3,2,1,5,6,4), 2))
    }

    @Test
    fun test2() {
        Assert.assertEquals(4, findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
    }
}