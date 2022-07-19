package learning.algorithms.trees;

public class TreeHeightAndDepth {

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        System.out.println("Height: " + getHeight(root)); // no of edges - connecting bars between two nodes
        System.out.println("Depth: " + getDepth(root)); // no of nodes
    }
    
}
