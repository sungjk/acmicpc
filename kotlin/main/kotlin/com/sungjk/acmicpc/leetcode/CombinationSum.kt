package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/11/05.
 */
class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        if (candidates.isEmpty()) return emptyList()
        return this.combinationSum(candidates, target, emptyList())
    }

    fun combinationSum(candidates: IntArray, target: Int, combination: List<Int>): List<List<Int>> {
        if (combination.sum() > target) return emptyList()
        if (combination.sum() == target) return listOf(combination)
        return candidates
            .map { this.combinationSum(candidates, target, combination.plus(it)) }
            .flatten()
            .distinctBy { it.sorted() }
    }

    @Test
    fun test0() {
        val expected = emptyList<Int>()
        Assert.assertEquals(expected, combinationSum(intArrayOf(), 0))
    }

    @Test
    fun test1() {
        val expected = listOf(
            listOf(2,2,3),
            listOf(7)
        )
        Assert.assertEquals(expected, combinationSum(intArrayOf(2,3,6,7), 7))
    }

    @Test
    fun test2() {
        val expected = listOf(
            listOf(2,2,2,2),
            listOf(2,3,3),
            listOf(3,5)
        )
        Assert.assertEquals(expected, combinationSum(intArrayOf(2,3,5), 8))
    }

    @Test
    fun test3() {
        val expected = listOf(
            listOf(2,3),
            listOf(5)
        )
        Assert.assertEquals(expected, combinationSum(intArrayOf(2,3,5), 5))
    }

    @Test
    fun test4() {
        val expected = listOf(
            listOf(5)
        )
        Assert.assertEquals(expected, combinationSum(intArrayOf(5), 5))
    }
}
