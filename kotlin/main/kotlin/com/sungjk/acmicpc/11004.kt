package com.sungjk.acmicpc

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * Created by jeremy on 09/25/2018.
 */
/*
5 2
4 1 2 3 5
 */
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = StringTokenizer(br.readLine())
    val length = str.nextToken().toInt()
    val arr = Array(length) { 0 }
    for (i in 0 until length) {
        arr[i] = str.nextToken().toInt()
    }
    arr.sort()

}
