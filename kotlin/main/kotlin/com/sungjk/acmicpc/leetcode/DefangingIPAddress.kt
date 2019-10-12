package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/12.
 */
class DefangingIPAddress {
    fun defangIPaddr(address: String): String {
        return address.replace(".", "[.]")
    }

    @Test
    fun test1() {
        Assert.assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"))
    }

    @Test
    fun test2() {
        Assert.assertEquals("255[.]100[.]50[.]0", defangIPaddr("255.100.50.0"))
    }
}