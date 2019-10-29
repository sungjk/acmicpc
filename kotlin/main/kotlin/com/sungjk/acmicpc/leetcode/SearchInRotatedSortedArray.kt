package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/29.
 */
class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        return this.search(nums, target, 0)
    }

    private fun search(nums: IntArray, target: Int, current: Int): Int {
        if (nums.size == current) return -1
        if (nums[current] == target) return current
        return this.search(nums, target, current + 1)
    }

    @Test
    fun test0() {
        Assert.assertEquals(-1, search(intArrayOf(), 0))
    }

    @Test
    fun test1() {
        Assert.assertEquals(4, search(intArrayOf(4,5,6,7,0,1,2), 0))
    }

    @Test
    fun test2() {
        Assert.assertEquals(-1, search(intArrayOf(4,5,6,7,0,1,2), 3))
    }
}
