package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * https://leetcode.com/problems/combination-sum-ii/
 *
 * Created by jeremy on 2019/11/06.
 */
class CombinationSum2 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        if (candidates.isEmpty()) return emptyList()
        val visited = BooleanArray(candidates.size) { false }
        return this.combinationSum2(candidates, target, visited, listOf())
    }

    fun combinationSum2(candidates: IntArray, target: Int, visited: BooleanArray, combination: List<Int>): List<List<Int>> {
        if (combination.sum() > target) return emptyList()
        if (combination.sum() == target) return listOf(combination)
        return candidates.withIndex()
            .filter { !visited[it.index] }
            .map {
                visited[it.index] = true
                val subCombination = this.combinationSum2(candidates, target, visited, combination.plus(it.value))
                visited[it.index] = false
                subCombination
            }
            .flatten()
            .distinctBy { it.sorted() }
    }

    @Test
    fun test0() {
        Assert.assertEquals(emptyList<Int>(), combinationSum2(intArrayOf(), 0))
    }

    @Test
    fun test1() {
        val expected = listOf(
            listOf(1, 2, 5),
            listOf(1, 7),
            listOf(1, 6, 1),
            listOf(2, 6)
        )
        Assert.assertEquals(expected, combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))
    }

    @Test
    fun test2() {
        val expected = listOf(
            listOf(2, 2, 1),
            listOf(5)
        )
        Assert.assertEquals(expected, combinationSum2(intArrayOf(2,5,2,1,2), 5))
    }
}
