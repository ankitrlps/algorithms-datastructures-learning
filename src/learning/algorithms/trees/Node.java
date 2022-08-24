package learning.algorithms.trees;

public class Node {
    int val;
    boolean visited = false;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}
