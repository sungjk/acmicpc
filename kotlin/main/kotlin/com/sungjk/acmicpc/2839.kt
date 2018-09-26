package com.sungjk.acmicpc

import java.util.*

/**
 * Created by jeremy on 09/25/2018.
 */
// 3 => 1
// 4 => -1
// 5 => 1
// 6 => 3+3 2
// 7 => -1
// 8 => 5+3 2
// 9 => 3+3+3 3
// 10 => 5+5 2
// 11 => 5+3+3 3
// 12 => 3+3+3+3 4
// 13 => 5+5+3 3
// 14 => 5+3+3+3 4
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val n = Integer.parseInt(input.nextLine())

    if (n == 4 || n == 7) { // 4, 7
        println(-1)
    } else if ((n % 5) == 0) { // 5, 10, ...
        println(n / 5)
    } else if ((n % 5) == 1 || (n % 5) == 3) { // 3, 6, 8, 11, 13, ...
        println(n / 5 + 1)
    } else if ((n % 5) == 2 || (n % 5) == 4) { // 12, 14, ...
        println(n / 5 + 2)
    }
}