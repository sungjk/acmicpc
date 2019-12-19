package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * https://leetcode.com/problems/valid-sudoku/
 * Created by Jeremy on 19/12/2019.
 */
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return board.indices.all { y ->
            board[y].indices.all { x ->
                validate(board, x, y)
            }
        }
    }

    fun validate(board: Array<CharArray>, x: Int, y: Int): Boolean {
        if (board[y][x] == '.') return true

        val containsInRow = (0 until 9).filter { it != y && board[it][x] != '.' }.any { yy ->
            board[yy][x] == board[y][x]
        }
        val containsInColumn = (0 until 9).filter { it != x && board[y][it] != '.' }.any { xx ->
            board[y][xx] == board[y][x]
        }
        val yy = (y / 3) * 3
        val xx = (x / 3) * 3
        val containsInBox = (yy until (yy + 3)).any { yyy ->
            (xx until (xx + 3)).any { xxx ->
                if (x == xxx && y == yyy) {
                    false
                } else {
                    board[yyy][xxx] == board[y][x]
                }
            }
        }
        return !containsInRow && !containsInColumn && !containsInBox
    }

    @Test
    fun test1() {
        val board = arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
        )
        Assert.assertEquals(true, isValidSudoku(board))
    }

    @Test
    fun test2() {
        val board = arrayOf(
            charArrayOf('8','3','.','.','7','.','.','.','.'),
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
        )
        Assert.assertEquals(false, isValidSudoku(board))
    }
}