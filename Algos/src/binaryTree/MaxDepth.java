package binaryTree;

/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2

Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return fetchMaxDepth(root);
    }

    private int fetchMaxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(fetchMaxDepth(root.left), fetchMaxDepth(root.right));
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(new int[]{1, 2, 3 , 4, 5, 6, 7, 8});
        MaxDepth maxDepth = new MaxDepth();
        System.out.println("Max depth of binary tree is " + maxDepth.maxDepth(tree.head));
        tree.insert(new int[]{1,3});
        System.out.println("Max depth of binary tree is " + maxDepth.maxDepth(tree.head));
    }

}
