package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Created by Jeremy on 12/12/2019.
 */
class KthSmallestElementInSortedMatrix {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        return matrix.flatMap { it.asIterable() }.sorted().drop(k - 1).first()
    }

    @Test
    fun test0() {
        val matrix = arrayOf(
            intArrayOf(0)
        )
        Assert.assertEquals(0, kthSmallest(matrix, 1))
    }

    @Test
    fun test1() {
        val matrix = arrayOf(
            intArrayOf(1,5,9),
            intArrayOf(10,11,13),
            intArrayOf(12,13,15)
        )
        Assert.assertEquals(13, kthSmallest(matrix, 8))
    }

    @Test
    fun test2() {
        val matrix = arrayOf(
            intArrayOf(1,2),
            intArrayOf(1,3)
        )
        Assert.assertEquals(1, kthSmallest(matrix, 2))
    }
}