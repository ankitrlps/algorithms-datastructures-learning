package learning.algorithms.trees;

public class InOrderSuccessorOfNodeInBT {

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.val) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    private static Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    private static Node getSuccessor(Node node, Node succ, int data) {
        if (node == null) {
            return succ;
        }
        if (node.val == data) {
            if (node.right != null) {
                return findMinNode(node.right);
            }
        }else if (data < node.val) {
            succ = node;
            return getSuccessor(node.left, succ, data);
        } else {
            return getSuccessor(node.right, succ, data);
        }
        return succ;
    }

    static void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.print(node.val + " ");
        print(node.right);
    }

    public static void main(String[] args) {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        /* Construct the following tree
                   15
                 /    \
                /      \
               10       20
              / \      /  \
             /   \    /    \
            8    12  16    25
        */
 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }

        print(root);
 
        //find inorder successor for each key
        for (int key: keys)
        {
            Node succ = getSuccessor(root, null, key);
 
            if (succ != null)
            {
                System.out.println("The successor of node " + key + " is "
                                    + succ.val);
            }
            else {
                System.out.println("No Successor exists for node " + key);
            }
        }
    }
}
