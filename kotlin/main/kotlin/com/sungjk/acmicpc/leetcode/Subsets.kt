package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/15.
 */
class Subsets {

    fun subsets(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return listOf(emptyList())
        this.subsets(nums, Math.pow(2.0, nums.size.toDouble()).toInt(), 0, mutableListOf())
        return listOf(emptyList())
    }
    // 2 [1]: [], [1]
    // 4 [1, 2]: [], [1], [2], [1, 2]
    // 8: [1, 2, 3]: [], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]
    // 16: [1, 2, 3, 4]: ...
    fun subsets(nums: IntArray, end: Int, start: Int, subsets: List<List<Int>>) {

    }

    @Test
    fun test0() {
        Assert.assertEquals(listOf(emptyList<Int>()), subsets(intArrayOf()))
    }

    @Test
    fun test1() {
        val expected = listOf(
            listOf(3),
            listOf(1),
            listOf(2),
            listOf(1,2,3),
            listOf(1,3),
            listOf(2,3),
            listOf(1,2)
        )
        Assert.assertEquals(expected, subsets(intArrayOf(1, 2, 3)))
    }

}
