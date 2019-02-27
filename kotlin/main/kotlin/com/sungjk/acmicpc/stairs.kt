package com.sungjk.acmicpc

/**
 * Created by jeremy on 02/20/2019.
 */
/*
N번째 계단에 있을떄
f(N) = f(N - 1) + f(N - 2) + f(N - 3)
O(3^n)
 */
fun up(curr: Int): Int {
    if (curr < 0) return 0
    if (curr == 0) return 1
    return up(curr - 1) + up(curr - 2) + up(curr - 3)
}

fun up2(curr: Int, memo: Array<Long>): Long {
    if (curr < 0) return 0
    if (curr == 0) return 1
    if (memo[curr] != 0L) return memo[curr]
    memo[curr] = up2(curr - 1, memo) + up2(curr - 2, memo) + up2(curr - 3, memo)
    return memo[curr]
}

fun main(args: Array<String>) {
    val n = 100
    for (i in 0 until n) {
//        println(up(i))
        println(up2(i, Array(100) { 0L }))
    }
}
