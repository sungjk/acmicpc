package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/16.
 */
class FindTheDuplicateNumber {

    fun findDuplicate(nums: IntArray): Int =
        nums.groupBy { it }
            .mapValues { it.value.size }
            .toList()
            .maxBy { it.second }!!
            .first

    @Test
    fun test0() {
        Assert.assertEquals(1, findDuplicate(intArrayOf(1)))
    }

    @Test
    fun test1() {
        Assert.assertEquals(2, findDuplicate(intArrayOf(1,3,4,2,2)))
    }

    @Test
    fun test2() {
        Assert.assertEquals(3, findDuplicate(intArrayOf(3,1,3,4,2)))
    }

}