package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Created by jeremy on 2020/02/21.
 */
class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int =
        getProfit(prices, 0, Int.MAX_VALUE, 0)

    fun getProfit(prices: IntArray, i: Int, minPrice: Int, maxProfit: Int): Int {
        if (i == prices.size) return maxProfit
        return when {
            minPrice > prices[i] ->
                getProfit(prices, i + 1, prices[i], maxProfit)
            prices[i] - minPrice > maxProfit ->
                getProfit(prices, i + 1, minPrice, prices[i] - minPrice)
            else ->
                getProfit(prices, i + 1, minPrice, maxProfit)
        }
    }

    @Test
    fun test1() {
        Assert.assertEquals(5, maxProfit(intArrayOf(7,1,5,3,6,4)))
    }

    @Test
    fun test2() {
        Assert.assertEquals(0, maxProfit(intArrayOf(7,6,4,3,1)))
    }
}
