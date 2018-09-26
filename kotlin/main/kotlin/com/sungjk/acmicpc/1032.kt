package com.sungjk.acmicpc

import java.util.*

/**
 * Created by jeremy on 09/25/2018.
 */
/*
3
config.sys
config.inf
configures
 */
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val testCases = Integer.parseInt(input.nextLine())
    val commands: Array<String> = Array(testCases) { "" }

    for (i in 0 until testCases) {
        commands[i] = input.nextLine()
    }

    var result: CharArray = commands[0].toCharArray()
    val length = commands[0].length
    for (i in 1 until testCases) {
        for (j in 0 until length) {
            if (result[j] != commands[i][j]) {
                result[j] = '?'
            }
        }
    }

    println(result)
}

