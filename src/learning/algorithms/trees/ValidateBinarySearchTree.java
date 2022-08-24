package learning.algorithms.trees;

public class ValidateBinarySearchTree {
    
    public boolean isValidBSTUsingRange(Node root) {
        check(root, null, null); // - BFS
        return check1(root); // - DFS
    }
    
    private static boolean check(Node node, Integer low, Integer high) {
        if (node == null) {
            return true; // because we reached the lead node and reaching lead node means above nodes are valid
        }
        
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }
        return check(node.left, low, node.val) && check(node.right, node.val, high);
    }


    static Integer prev = null;
    
    private static boolean check1(Node node) {
        if (node == null) {
            return true;
        }
        if (!check1(node.left)) {
            return false;
        }
        if (prev != null && node.val <= prev) {
            return false;
        }
        
        prev = node.val;
        
        return check1(node.right);
    }

    public static void main(String[] args) {
        
    }
}
