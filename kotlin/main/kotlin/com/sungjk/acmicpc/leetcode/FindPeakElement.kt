package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * https://leetcode.com/problems/find-peak-element/
 * Created by Jeremy on 16/12/2019.
 */
class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        return find(nums, 0, nums.size - 1)
    }

    fun find(nums: IntArray, left: Int, right: Int): Int {
        if (left == right) {
            return left
        }

        val mid = (left + right) / 2
        if (nums[mid] > nums[mid + 1]) {
            return find(nums, left, mid)
        }
        return find(nums, mid + 1, right)
    }

    @Test
    fun test0() {
        Assert.assertEquals(0, findPeakElement(intArrayOf(1)))
    }

    @Test
    fun test1() {
        Assert.assertEquals(2, findPeakElement(intArrayOf(1,2,3,1)))
    }

    @Test
    fun test2() {
        Assert.assertEquals(5, findPeakElement(intArrayOf(1,2,1,3,5,6,4)))
    }

    @Test
    fun test3() {
        Assert.assertEquals(5, findPeakElement(intArrayOf(1,1,1,3,5,6,4)))
    }

    @Test
    fun test4() {
        Assert.assertEquals(5, findPeakElement(intArrayOf(1,2,1,3,5,5,4)))
    }

    @Test
    fun test5() {
        Assert.assertEquals(1, findPeakElement(intArrayOf(1,2)))
    }

    @Test
    fun test6() {
        Assert.assertEquals(2, findPeakElement(intArrayOf(1,1,5)))
    }
}