package com.CK;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node9 = new TreeNode(8);
//        TreeNode node10 = new TreeNode(9);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node13 = new TreeNode(9);
//        TreeNode node14 = new TreeNode(8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        new Solution().countUnivalSubtrees(root);

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int count;

    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        isUnivalSubtree(root);
        return count;
    }

    private boolean isUnivalSubtree(TreeNode root){
        if (root == null)
            return true;
        boolean leftUnival = isUnivalSubtree(root.left);
        boolean rightUnival = isUnivalSubtree(root.right);

        if (leftUnival && rightUnival){
            if (root.left == null && root.right == null){
                count++;
                return true;
            }

            if (root.left == null ){
                if (root.val == root.right.val) {
                    count++;
                    return true;
                } else
                    return false;
            }

            if (root.right == null ){
                if (root.val == root.left.val) {
                    count++;
                    return true;
                } else
                    return false;
            }

            if (root.val == root.left.val && root.val == root.right.val){
                count++;
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}