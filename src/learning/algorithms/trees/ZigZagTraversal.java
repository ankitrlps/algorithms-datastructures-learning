package learning.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        result.add(rootList);
        if (root.left == null && root.right == null) {
            return result;
        }
        int depth = 1;
        LinkedList<Node> ll = new LinkedList<>();
        ll.add(root);
        while(!ll.isEmpty()) {
            LinkedList<Node> tempLL = new LinkedList<>();
            List<Integer> depthList = new ArrayList<>();
            if (depth % 2 == 0) {
                while (!ll.isEmpty()) {
                    Node node = ll.pollLast();
                    Integer left = null;
                    Integer right = null;
                    if (node.left != null) {
                        left = node.left.val;                        
                        tempLL.add(node.left);
                    }
                    if (node.right != null) {
                        right = node.right.val;
                        tempLL.add(node.right);
                    }
                    if (left == null && right == null) {
                        continue;
                    }
                    if (left != null) depthList.add(left);
                    if (right != null) depthList.add(right);
                }
                if (!depthList.isEmpty()) result.add(depthList);
            } else {
                while (!ll.isEmpty()) {
                    Node node = ll.pollLast();
                    Integer left = null;
                    Integer right = null;
                    if (node.right != null) {
                        right = node.right.val;
                        tempLL.add(node.right);
                    }
                    if (node.left != null) {
                        left = node.left.val;                        
                        tempLL.add(node.left);
                    }
                    if (left == null && right == null) {
                        continue;
                    }
                    if (right != null) depthList.add(right);
                    if (left != null) depthList.add(left);
                }
                if (!depthList.isEmpty()) result.add(depthList);
            }
            ll = tempLL;
            depth++;
        }
        return result;
    }

    public static void main(String[] args) {
        
    }    
}
