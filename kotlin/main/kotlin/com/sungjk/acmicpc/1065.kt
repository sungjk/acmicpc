package com.sungjk.acmicpc

import java.util.*

/**
 * Created by jeremy on 09/30/2018.
 */
fun solve(current: Int, N: Int): Int {
    if (current > N) return 0
    val num100 = current / 100
    val num10 = current % 100 / 10
    val num1 = current % 10
    val isHansu = num100 - num10 == num10 - num1
    return if (isHansu) 1 + solve(current + 1, N) else solve(current + 1, N)
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val N = Integer.parseInt(input.nextLine())
    when (N) {
        in 1..99 -> println(N)
        else -> println(99 + solve(100, N))
    }
}