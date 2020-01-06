package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Created by Jeremy on 06/01/2020.
 */
public class ValidateBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        if (lower != null && lower >= node.val) return false;
        if (upper != null && node.val >= upper) return false;
        if (!validate(node.left, lower, node.val)) return false;
        if (!validate(node.right, node.val, upper)) return false;
        return true;
    }

    public static class UnitTest {
        @Test
        public void test1() {
            TreeNode tree = new TreeNode(2);
            tree.left = new TreeNode(1);
            tree.right = new TreeNode(3);
            Assert.assertTrue(isValidBST(tree));
        }

        @Test
        public void test2() {
            TreeNode tree = new TreeNode(5);
            tree.left = new TreeNode(1);
            TreeNode rightNode = new TreeNode(4);
            rightNode.left = new TreeNode(3);
            rightNode.right = new TreeNode(6);
            tree.right = rightNode;
            Assert.assertFalse(isValidBST(tree));
        }

        @Test
        public void test3() {
            TreeNode tree = new TreeNode(10);
            tree.left = new TreeNode(5);
            TreeNode rightNode = new TreeNode(15);
            rightNode.left = new TreeNode(6);
            rightNode.right = new TreeNode(20);
            tree.right = rightNode;
            Assert.assertFalse(isValidBST(tree));
        }
    }
}
