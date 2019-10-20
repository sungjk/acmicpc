package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/20.
 */
class Permutations {

    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return listOf(emptyList())
        val permutations = mutableListOf<List<Int>>()
        this.permute(nums, 0, listOf(), permutations)
        return permutations
    }

    fun permute(nums: IntArray, start: Int, permutation: List<Int>, permutations: MutableList<List<Int>>) {
        if (nums.size == start) {
            permutations.add(permutation)
            return
        }

        nums.indices.map {
            if (!permutation.contains(nums[it])) {
                this.permute(nums, start + 1, permutation.plus(nums[it]), permutations)
            }
        }
    }

    @Test
    fun test0() {
        Assert.assertEquals(listOf(emptyList<Int>()), this.permute(intArrayOf()))
    }

    @Test
    fun test1() {
        val expected = listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1)
        )
        Assert.assertEquals(expected, this.permute(intArrayOf(1, 2, 3)))
    }

    @Test
    fun test2() {
        val expected = listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1)
        )
        Assert.assertEquals(expected, this.permute(intArrayOf(1, 2, 3)))
    }

}