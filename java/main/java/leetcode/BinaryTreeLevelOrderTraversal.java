package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jeremy on 2020/11/14.
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                currentLevel.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            traversal.add(currentLevel);
        }

        return traversal;
    }

    public static class UnitTest {
        @Test
        public void test1() {
            BinaryTreeLevelOrderTraversal.TreeNode root = new BinaryTreeLevelOrderTraversal.TreeNode(3);
            BinaryTreeLevelOrderTraversal.TreeNode left = new BinaryTreeLevelOrderTraversal.TreeNode(9);
            BinaryTreeLevelOrderTraversal.TreeNode rightLeft = new BinaryTreeLevelOrderTraversal.TreeNode(15);
            BinaryTreeLevelOrderTraversal.TreeNode rightRight = new BinaryTreeLevelOrderTraversal.TreeNode(7);
            BinaryTreeLevelOrderTraversal.TreeNode right = new BinaryTreeLevelOrderTraversal.TreeNode(20);
            right.left = rightLeft;
            right.right = rightRight;
            root.left = left;
            root.right = right;

            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
            );
            Assert.assertEquals(expected, levelOrder(root));
        }
    }
}

