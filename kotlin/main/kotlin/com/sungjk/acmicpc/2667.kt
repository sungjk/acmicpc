package com.sungjk.acmicpc

import java.util.*

/**
 * Created by jeremy on 12/15/2018.
 */
class Village(var map: Array<IntArray>) {
    private val EMPTY = 0
    private val VISITED = 1
    private val direction: List<List<Int>> = listOf(
        listOf(-1, 0),  // DOWN
        listOf(1, 0),   // UP
        listOf(0, -1),  // LEFT
        listOf(0, 1)    // RIGHT
    )
    var visited: Array<IntArray> = Array(map.size) { IntArray(map.size) }

    private fun canGo(x: Int, y: Int): Boolean {
        if (x < 0 || x > map[0].size - 1) return false
        if (y < 0 || y > map.size - 1) return false
        if (VISITED == visited[y][x]) return false
        if (EMPTY == map[y][x]) return false
        return true
    }

    fun tour(x: Int, y: Int): Int {
        var count = 1
        val queue = Queue(x, y)
        visited[y][x] = VISITED

        while (!queue.empty()) {
            val currentNode = queue.peak()
            for (dir in 0 until direction.size) {
                val nextX = currentNode!!.x + direction[dir][0]
                val nextY = currentNode.y + direction[dir][1]
                if (canGo(nextX, nextY)) {
                    count++
                    queue.push(QueueNode(nextX, nextY))
                    visited[nextY][nextX] = VISITED
                }
            }
        }

        return count
    }

    inner class Queue(startX: Int, startY: Int) {
        var head: QueueNode? = QueueNode(startX, startY)
        var tail: QueueNode? = QueueNode(startX, startY)

        fun empty(): Boolean = this.head?.let { false } ?: run { true }

        fun peak(): QueueNode? =
            this.head?.let {
                val front = this.head!!
                head = front.next
                head ?: run { this.tail = null }
                front
            } ?: run {
                null
            }

        fun push(node: QueueNode) {
            this.tail?.let {
                this.tail!!.next = node
                this.tail = node
                this.head ?: run { this.head = this.tail }
            } ?: run {
                this.head = node
                this.tail = node
            }
        }
    }

    inner class QueueNode(val x: Int, val y: Int) {
        var next: QueueNode? = null
    }
}

/*
input:
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

output:
3
7
8
9
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = Integer.parseInt(scanner.nextLine())
    var map: Array<IntArray> = Array(n) { IntArray(n) }
    for (y in 0 until map.size) {
        val row = scanner.next()
        for (x in 0 until row.length) {
            map[y][x] = row[x].toInt() - 48
        }
    }

    val village = Village(map)
    var numOfArea = 0
    var houseInAreas = mutableListOf<Int>()
    for (y in 0 until map.size) {
        for (x in 0 until map[0].size) {
            if (0 == village.visited[y][x] && 1 == village.map[y][x]) {
                numOfArea++
                houseInAreas.add(village.tour(x, y))
            }
        }
    }

    println(numOfArea)
    houseInAreas.sort()
    houseInAreas.forEach { println(it) }
}
