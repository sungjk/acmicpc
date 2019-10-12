package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/12.
 */
class ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var (maxArea, left, right) = Triple(0, 0, height.size - 1)
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left))
            if (height[left]< height[right]) left++ else right--
        }
        return maxArea
    }

    // [Memory Limit Exceeded] Array size: 9999
//    fun maxArea(height: IntArray): Int {
//        val cache =  Array(height.size) { IntArray(height.size) }
//        return this.maxArea(height, cache, 0, height.size - 1)
//    }
//
//    fun maxArea(waters: IntArray, cache: Array<IntArray>, head: Int, tail: Int): Int {
//        if (head >= tail) return 0
//        if (cache[head][tail] > 0) return cache[head][tail]
//
//        val currentArea = (tail - head) * (min(waters[head], waters[tail]))
//        val headUpArea = max(currentArea, this.maxArea(waters, cache, head + 1, tail))
//        val tailDownArea = max(currentArea, this.maxArea(waters, cache, head, tail - 1))
//        cache[head][tail] = max(headUpArea, tailDownArea)
//        return cache[head][tail]
//    }

    @Test
    fun test() {
        Assert.assertEquals(49, maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    }

    @Test
    fun test2() {
        Assert.assertEquals(1, maxArea(intArrayOf(1, 1)))
    }

    @Test
    fun test3() {
        Assert.assertEquals(1, maxArea(intArrayOf(1, 10)))
    }

    @Test
    fun test4() {
        Assert.assertEquals(0, maxArea(intArrayOf(0, 0)))
    }
}