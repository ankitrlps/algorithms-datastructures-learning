package learning.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * link - https://www.hackerrank.com/challenges/swap-nodes-algo/problem?isFullScreen=false
 */

public class SwapNodesBinaryTree {

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();        
        Node tree = constructTree(indexes, indexes.get(0).get(0));
        
        int queryCount = 1;
        while (queryCount <= queries.get(0)) {
            int depth = queries.get(queryCount);
            List<Integer> list = new ArrayList<>();
            traverseAndSwapNodes(tree, depth, list);
            res.add(list);
            queryCount++;
        }
        return res;
    }
    
    private static void traverseAndSwapNodes(Node node, int depth, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        if (node.depth % depth == 0) {
            Node prevLeft = node.left;
            Node prevRight = node.right;
            node.left = prevRight;
            node.right = prevLeft;
            
        }
        traverseAndSwapNodes(node.left, depth, list);
        list.add(node.val);
        traverseAndSwapNodes(node.right, depth, list);
    }
    
    // h = k, 2k, 3k...
    // k = 1 then h = 1, 2, 3
    // k = 2 then h = 2, 4, 6
    
    private static Node constructTree(List<List<Integer>> indexes, int count) {
        int i = 1;
        Node root = new Node(1, 1);
        Node node = root;
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        while (i <= count && !que.isEmpty()) {
            Node queNode = que.poll();
            int left = indexes.get(i).get(0);
            int right = indexes.get(i).get(1);
            int depth = queNode.depth + 1;
            if (left != -1) {
                queNode.left = new Node(left, depth);
                que.add(queNode.left);
            }
            if (right != -1) {
                queNode.right = new Node(right, depth);
                que.add(queNode.right);
            }
            i++;
        }        
        return root;
    }

static class Node {
    int val;
    Node left;
    Node right;
    int depth;
    public Node(int val, int depth) {
        left = right = null;
        this.val = val;
        this.depth = depth;
    }
}

    /**
     * in order traversal
     * 
     * @param root
     */
    private void printTree(Node root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.println(root.val + " " + root.depth);
        printTree(root.right);
    }

    public static void main(String[] args) {
        List<List<Integer>> indexes = new ArrayList<>();
        // indexes.add(addVals(5, 0));
        // indexes.add(addVals(2, 3));
        // indexes.add(addVals(-1, 4));
        // indexes.add(addVals(-1, 5));
        // indexes.add(addVals(-1, -1));
        // indexes.add(addVals(-1, -1));
        // indexes.add(addVals(4, 5));
        // indexes.add(addVals(6, 7));

        indexes.add(addVals(11, 0));
        indexes.add(addVals(2, 3));
        indexes.add(addVals(4, -1));
        indexes.add(addVals(5, -1));
        indexes.add(addVals(6, -1));
        indexes.add(addVals(7, 8));
        indexes.add(addVals(-1, 9));
        indexes.add(addVals(-1, -1));
        indexes.add(addVals(10, 11));
        indexes.add(addVals(-1, -1));
        indexes.add(addVals(-1, -1));
        indexes.add(addVals(-1, -1));

        List<Integer> queries = new ArrayList<>();
        // queries.add(1);
        // queries.add(2);

        queries.add(2);
        queries.add(2);
        queries.add(4);

        List<List<Integer>> result = swapNodes(indexes, queries);
        result.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
        //binaryTree.printTree(tree);
    }

    private static List<Integer> addVals(int a, int b) {
        List<Integer> vals = new ArrayList<>();
        vals.add(a);
        vals.add(b);
        return vals;
    }
}
