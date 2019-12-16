package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 * Created by Jeremy on 12/12/2019.
 */
class WiggleSortII {
    fun wiggleSort(nums: IntArray): Unit {
        // nums: 1,5,1,1,6,4
        nums.sort()
        // sorted: 1,1,1,4,5,6
        // 1 < 6 > 1 < 5 > 1 < 4
        val sorted = nums.clone()
        val size = nums.size
        var mid = if (size % 2 == 0) size / 2 - 1 else size / 2
        var end = size - 1
        for (i in nums.indices) {
             nums[i] = if (i % 2 == 0) sorted[mid--] else sorted[end--]
        }
    }

    @Test
    fun test1() {
        val nums = intArrayOf(1, 5, 1, 1, 6, 4).also { wiggleSort(it) }
        Assert.assertArrayEquals(intArrayOf(1,6,1,5,1,4), nums)
    }

    @Test
    fun test2() {
        val nums = intArrayOf(1, 3, 2, 2, 3, 1).also { wiggleSort(it) }
        Assert.assertArrayEquals(intArrayOf(2,3,1,3,1,2), nums)
    }
}