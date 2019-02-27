package com.sungjk.acmicpc

/**
 * Created by jeremy on 02/20/2019.
 */
fun main(args: Array<String>) {
//    val input = "aabcccccaaa" // a2b1c5a3
    val input = "abcd" // a1b1c1d1

    val allCharsMap = LinkedHashMap<Char, Int>(input.length)
    CharRange('a', 'z').forEach { allCharsMap[it] = 0 }
    input.forEach { s -> allCharsMap[s] = allCharsMap[s]!! + 1 }

    val compressed = allCharsMap.toList().filter { it.second > 0 }.joinToString("") { it.first + "" + it.second }
    if (input.length > compressed.length) print(compressed) else print(input)
}
