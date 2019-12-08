package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * https://leetcode.com/problems/number-of-islands/
 * Created by Jeremy on 08/12/2019.
 */
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }
        return grid.mapIndexed { y, chars -> chars
            .mapIndexed { x, _ ->
                mark(grid, visited, x, y)
            }.sum()
        }.sum()
    }

    fun mark(grid: Array<CharArray>, visited: Array<BooleanArray>, x: Int, y: Int): Int =
        when (canGo(grid, visited, x, y)) {
            true -> {
                visited[y][x] = true
                if (canGo(grid, visited, x, y + 1)) mark(grid, visited, x, y + 1)
                if (canGo(grid, visited, x + 1, y)) mark(grid, visited, x + 1, y)
                if (canGo(grid, visited, x - 1, y)) mark(grid, visited, x - 1, y)
                if (canGo(grid, visited, x, y - 1)) mark(grid, visited, x, y - 1)
                1
            }
            false -> 0
        }

    fun canGo(grid: Array<CharArray>, visited: Array<BooleanArray>, x: Int, y: Int): Boolean {
        if (y < 0 || y > grid.size - 1) return false
        if (x < 0 || x > grid[0].size - 1) return false
        if (visited[y][x]) return false
        if (grid[y][x] != '1') return false
        return true
    }

    @Test
    fun test1() {
        Assert.assertEquals(1, numIslands(arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        )))
    }

    @Test
    fun test2() {
        Assert.assertEquals(3, numIslands(arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        )))
    }
}