package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/15.
 */
class TopKFrequentElements {

    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val map = mutableMapOf<Int, Int>()
        return nums
            .map { num ->
                if (map.containsKey(num)) {
                    val prev = map[num]!!
                    Pair(num, prev + 1)
                } else {
                    Pair(num, 1)
                }
            }
            .toMap()
            .entries
            .asSequence()
            .distinctBy { it.key }
            .sortedByDescending { it.value }
            .take(k)
            .map { it.key }
            .sorted()
            .toList()
    }

    @Test
    fun test0() {
        Assert.assertEquals(listOf(1, 2), topKFrequent(intArrayOf(1,2), 2))
    }

    @Test
    fun test1() {
        Assert.assertEquals(listOf(1, 2), topKFrequent(intArrayOf(1,1,1,2,2,3), 2))
    }

    @Test
    fun test2() {
        Assert.assertEquals(listOf(1), topKFrequent(intArrayOf(1), 1))
    }

    @Test
    fun test3() {
        Assert.assertEquals(listOf(1), topKFrequent(intArrayOf(1, 1), 1))
    }

    @Test
    fun test4() {
        Assert.assertEquals(listOf(-1), topKFrequent(intArrayOf(-1, -1), 1))
    }

    @Test
    fun test5() {
        Assert.assertEquals(listOf(1, 2), topKFrequent(intArrayOf(2, 1), 2))
    }

    @Test
    fun test6() {
        Assert.assertEquals(listOf(0), topKFrequent(intArrayOf(3, 0, 1, 0), 1))
    }

    @Test
    fun test7() {
        Assert.assertEquals(listOf(-1, 2), topKFrequent(intArrayOf(4, 1, -1, 2, -1, 2, 3), 2))
    }

}