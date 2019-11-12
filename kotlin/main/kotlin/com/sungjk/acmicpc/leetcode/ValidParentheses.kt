package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/23.
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()
        s.forEach {
            if (this.isOpen(it)) stack.add(it) else {
                val parenthesis: Char = if (stack.isEmpty()) 'a' else stack.last()
                if (!this.isPair(it, parenthesis)) {
                    return false
                }
                stack.removeAt(stack.size - 1)
            }
        }

        return stack.isEmpty()
    }

    private fun isOpen(c: Char): Boolean = c == '(' || c == '{' || c == '['

    private fun isPair(a: Char, b: Char): Boolean =
        when (Pair(a, b)) {
            Pair('(', ')') -> true
            Pair('{', '}') -> true
            Pair('[', ']') -> true
            Pair(')', '(') -> true
            Pair('}', '{') -> true
            Pair(']', '[') -> true
            else -> false
        }

    @Test
    fun test0() {
        Assert.assertEquals(true, isValid(""))
    }

    @Test
    fun test1() {
        Assert.assertEquals(true, isValid("()"))
    }

    @Test
    fun test2() {
        Assert.assertEquals(true, isValid("()[]{}"))
    }

    @Test
    fun test3() {
        Assert.assertEquals(false, isValid("(]"))
    }

    @Test
    fun test4() {
        Assert.assertEquals(true, isValid("{[]}"))
    }

    @Test
    fun test5() {
        Assert.assertEquals(false, isValid("}{}{"))
    }

    @Test
    fun test6() {
        Assert.assertEquals(false, isValid("([)]"))
    }

    @Test
    fun test7() {
        Assert.assertEquals(false, isValid("]"))
    }
}
