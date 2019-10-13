package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/12.
 */
/*
0   0       0
1   1       1
=============
2   10      1
3   11      2
=============
4   100     1
5   101     2
6   110     2
7   111     3
=============
8   1000    1
9   1001    2
10  1010    2
11  1011    3
12  1100    2
13  1101    3
14  1110    3
15  1111    4
=============
16  10000   1
17  10001   2
...
 */
class CountingBits {

    fun countBits(num: Int): IntArray {
        var bits = IntArray(num + 1)
        var i = 0
        while (i <= num) {
            if (i > 3 && bits[i - 1] == 1) {
                // copy from previous bits
                for ((index, j) in ((i / 2) until i).withIndex()) {
                    if (i + index <= num) {
                        bits[i + index] = bits[j + 1]
                    }
                }
                i += (i / 2) - 1
            } else {
                bits[i] = this.countOnes(i)
                i++
            }
        }
        return bits
    }

    private fun countOnes(num: Int): Int {
        if (num <= 0) return 0
        val nextCount = this.countOnes(num / 2)
        return if (num % 2 == 0) nextCount else 1 + nextCount
    }

    @Test
    fun testCountOnes() {
        Assert.assertEquals(3, this.countOnes(7))
    }

    @Test
    fun test0() {
        Assert.assertArrayEquals(intArrayOf(0), countBits(0))
    }

    @Test
    fun test1() {
        Assert.assertArrayEquals(intArrayOf(0, 1), countBits(1))
    }

    @Test
    fun test2() {
        Assert.assertArrayEquals(intArrayOf(0, 1, 1), countBits(2))
    }

    @Test
    fun test3() {
        Assert.assertArrayEquals(intArrayOf(0, 1, 1, 2), countBits(3))
    }

    @Test
    fun test4() {
        Assert.assertArrayEquals(intArrayOf(0, 1, 1, 2, 1), countBits(4))
    }

    @Test
    fun test5() {
        Assert.assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2), countBits(5))
    }

    @Test
    fun test6() {
        Assert.assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2, 2), countBits(6))
    }

    @Test
    fun test7() {
        Assert.assertArrayEquals(intArrayOf(0,1,1,2,1,2,2,3), countBits(7))
    }

    @Test
    fun test15() {
        Assert.assertArrayEquals(intArrayOf(0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4), countBits(15))
    }

}