package learning.algorithms.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class BTInorderTraversal {
    
    static List<Integer> list;
    
    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    
    public List<Integer> inorderTraversal(Node root) {
        list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        inOrder(root);
        return list;
    }

    public static void main(String[] args) {
        // Node = [1,null,2,3] 
    }
}
