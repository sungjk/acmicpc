package com.sungjk.acmicpc.leetcode

import org.junit.Assert
import org.junit.Test

/**
 * Created by jeremy on 2019/10/13.
 */
class BinaryTreeInorderTraversal {
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    inner class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val left = this.inorderTraversal(root.left)
        val current = root.`val`
        val right = this.inorderTraversal(root.right)
        return left.plus(current).plus(right)
    }

    @Test
    fun test0() {
        Assert.assertEquals(emptyList<Int>(), inorderTraversal(null))
    }

    @Test
    fun test1() {
        val a = TreeNode(1)
        a.right = TreeNode(2)
        a.right!!.left = TreeNode(3)

        Assert.assertEquals(listOf(1, 3, 2), inorderTraversal(a))
    }

}