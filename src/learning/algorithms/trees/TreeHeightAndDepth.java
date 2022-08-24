package learning.algorithms.trees;

public class TreeHeightAndDepth {

    private static int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static int getDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(1);
        System.out.println("Height: " + getHeight(root)); // no of edges - connecting bars between two nodes
        System.out.println("Depth: " + getDepth(root)); // no of nodes
    }
    
}
