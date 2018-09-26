package com.sungjk.acmicpc

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * Created by jeremy on 09/25/2018.
 */
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    val scores: Array<Double> = Array(n) { 0.0 }
    val str = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        scores[i] = str.nextToken().toDouble()
    }
    val maxScore = scores.max()!!.toDouble()
    for (i in 0 until n) {
        scores[i] = scores[i] / maxScore * 100
    }

    println("%.2f".format(scores.average()))
}