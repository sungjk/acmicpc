package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test
import kotlin.math.min

/**
 * https://leetcode.com/problems/maximal-square/
 * Created by Jeremy on 10/12/2019.
 */
class MaximalSquare {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0

        val marked = Array(matrix.size) { IntArray(matrix[0].size) { 0 }}
        val newMatrix: Array<IntArray> = matrix.map { chars ->
            chars.map { it.toInt() - 48 }.toIntArray()
        }.toTypedArray()

        val size = newMatrix.mapIndexed { y, ints ->
            (ints.indices).map { x ->
                mark(newMatrix, marked, x, y)
            }.max()!!
        }.max()!!

        return size * size
    }

    fun mark(matrix: Array<IntArray>, marked: Array<IntArray>, x: Int, y: Int): Int =
        if (y >= matrix.size || x >= matrix[0].size) 0 else {
            when {
                matrix[y][x] == 0 -> {
                    marked[y][x] = 0
                    marked[y][x]
                }
                marked[y][x] > 0 -> {
                    marked[y][x]
                }
                else -> {
                    val goRight = mark(matrix, marked, x + 1, y)
                    val goDown = mark(matrix, marked, x, y + 1)
                    val goRightDown = mark(matrix, marked, x + 1, y + 1)
                    marked[y][x] = 1 + min(goRight, min(goDown, goRightDown))
                    marked[y][x]
                }
            }
        }

    @Test
    fun test0() {
        Assert.assertEquals(0, maximalSquare(arrayOf(charArrayOf())))
    }

    @Test
    fun test1() {
        Assert.assertEquals(1, maximalSquare(arrayOf(charArrayOf('1'))))
    }

    @Test
    fun test2() {
        Assert.assertEquals(4, maximalSquare(arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0')
        )))
    }

    @Test
    fun test3() {
        Assert.assertEquals(9, maximalSquare(arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '1', '1', '1')
        )))
    }

    @Test
    fun test4() {
        Assert.assertEquals(9, maximalSquare(arrayOf(
            charArrayOf('0', '0', '0', '1'),
            charArrayOf('1', '1', '0', '1'),
            charArrayOf('1', '1', '1', '1'),
            charArrayOf('0', '1', '1', '1'),
            charArrayOf('0', '1', '1', '1')
        )))
    }
}