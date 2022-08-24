package learning.algorithms.trees;

public class PrintLeftSideOfBTree {

    int prevLevel = 0;
    
    private void printLeftView(Node node, int currLevel) {
        if (node == null) {
            return;
        }
        if (prevLevel < currLevel) {
            System.out.print(node.val + " ");
            prevLevel = currLevel;
        }
        printLeftView(node.left, currLevel + 1);
        printLeftView(node.right, currLevel + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.right.right = new Node(5);
        root.right.right.left = new Node(6);

        PrintLeftSideOfBTree tree = new PrintLeftSideOfBTree();
        tree.printLeftView(root, 1);
    }
    
}
