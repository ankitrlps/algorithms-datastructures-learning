package learning.algorithms.trees;

public class PrintLeftSideOfBTree {

    int prevLevel = 0;
    
    private void printLeftView(TreeNode node, int currLevel) {
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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);

        PrintLeftSideOfBTree tree = new PrintLeftSideOfBTree();
        tree.printLeftView(root, 1);
    }
    
}
