package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/22.
 */
class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        return this.generateParenthesis(n, "", 0, 0)
    }

    fun generateParenthesis(n: Int, parenthesis: String, open: Int, close: Int): List<String> {
        if (n * 2 == parenthesis.length) {
            return listOf(parenthesis)
        }

        val answer = mutableListOf<List<String>>()
        if (open < n) {
            answer.add(this.generateParenthesis(n, "$parenthesis(", open + 1, close))
        }
        if (close < open) {
            answer.add(this.generateParenthesis(n, "$parenthesis)", open, close + 1))
        }
        return answer.flatten()
    }

    @Test
    fun test0() {
        Assert.assertEquals(listOf(""), generateParenthesis(0))
    }

    @Test
    fun test1() {
        val expected = listOf("((()))","(()())","(())()","()(())","()()()")
        Assert.assertEquals(expected, generateParenthesis(3))
    }

    @Test
    fun test2() {
        val expected = listOf("((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()")
        Assert.assertEquals(expected, generateParenthesis(5))
    }
}