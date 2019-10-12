package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 12/10/2019.
 */
class LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        if (s.length <= 1) return s

        val map: Array<BooleanArray> = Array(s.length) { BooleanArray(s.length) }
        var longestLength = 0
        var longestSubString = ""

        for (j in s.indices) {
            for (i in 0..j) {
                // LPS[i, j]: s[i] == s[j] && LPS[i + 1, j - 1] + 2
                map[i][j] = if (i + 1 < j - 1) map[i + 1][j - 1] && s[i] == s[j] else s[i] == s[j]
                if (map[i][j] && j + 1 - i > longestLength) {
                    longestLength = j + 1 - i
                    longestSubString = s.substring(i, j + 1)
                }
            }
        }

        return longestSubString
    }

    @Test
    fun test() {
        Assert.assertEquals("bab", longestPalindrome("babad"))
    }

    @Test
    fun test2() {
        Assert.assertEquals("bb", longestPalindrome("cbbd"))
    }

    @Test
    fun test3() {
        Assert.assertEquals("abcba", longestPalindrome("abcba"))
    }

    @Test
    fun test4() {
        Assert.assertEquals("abccba", longestPalindrome("abccba"))
    }

    @Test
    fun test5() {
        Assert.assertEquals("a", longestPalindrome("a"))
    }

    @Test
    fun test6() {
        Assert.assertEquals("", longestPalindrome(""))
    }
}



