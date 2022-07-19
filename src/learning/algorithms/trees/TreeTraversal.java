package learning.algorithms.trees;

public class TreeTraversal {

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {            
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeTraversal traversal = new TreeTraversal();
        System.out.println("---- Pre-Order Traversal ----");
        traversal.preOrder(root);
        System.out.println();
        System.out.println("---- In-Order Traversal ----");
        traversal.inOrder(root);
        System.out.println();
        System.out.println("---- Post-Order Traversal ----");
        traversal.postOrder(root);
    }
    
}


//              1
//            /  \
//          2     3
//        /  \   
//      4     5

