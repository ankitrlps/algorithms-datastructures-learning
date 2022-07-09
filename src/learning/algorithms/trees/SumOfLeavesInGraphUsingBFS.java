package learning.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeavesInGraphUsingBFS {

    static class Node {
        int val;
        boolean visited = false;
        Node[] nodes;
        public Node(int val) {
            this.val = val;
        }
    }

    private static int sumOfLeaves(Node head) {
        bfs(head);
        return sum;
    }
    
    static int sum = 0; // static variable
    static Queue<Node> que = new LinkedList<>(); // static variable

    private static void bfs(Node head) {
        if (!head.visited) {
            head.visited = true;
            que.add(head);
            System.out.println(que.peek().val + " ");
        }
        while (!que.isEmpty()) {
            Node next = que.poll();
            if (next.nodes == null) {
                sum += next.val;
            } else {
                for (Node neighbour : next.nodes) {
                    if (!neighbour.visited) {
                        neighbour.visited = true;
                        que.add(neighbour);  
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.nodes = new Node[]{new Node(4), new Node(3)};
        head.nodes[0].nodes = new Node[]{new Node(1), new Node(-6)}; // Node 4 => 1, -6
        head.nodes[0].nodes[0].nodes = new Node[]{new Node(2), new Node(9)}; // Node 1 => 2, 9
        head.nodes[1].nodes = new Node[]{new Node(0), new Node(7), new Node(-4)}; // Node 3 => 0, 7, -4
        head.nodes[1].nodes[1].nodes = new Node[]{new Node(8)}; // Node 7 => 8
        System.out.println("sum: " + sumOfLeaves(head));
    }
    
}
