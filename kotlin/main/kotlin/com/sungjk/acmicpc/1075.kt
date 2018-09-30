package com.sungjk.acmicpc

import java.util.*

/**
 * Created by jeremy on 09/30/2018.
 */
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val N: Long = input.nextLong()
    val F: Int = input.nextInt()
    val num = N - N % 100
    for (i in 0 until 99) {
        if ((num + i) % F == 0L) {
            when (i) {
                in 0..9 -> println("0$i")
                else -> println(i)
            }
            break
        }
    }
}