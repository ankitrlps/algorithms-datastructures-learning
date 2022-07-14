package learning.algorithms.leetcode.easy.graphs;

public class SumOfLeavesInGraphUsingDFS {

    static class Node {
        int val;
        boolean visited = false;
        Node[] nodes;
        public Node(int val) {
            this.val = val;
        }
    }

    private static int sumOfLeaves(Node head) {
        int sum = 0;
        if (head == null) {
            return 0;
        }
        Node curr = head;
        if (!curr.visited) {
            curr.visited = true;
        }
        return sum = dfs(curr, sum);
    }

    //static int sum = 0;
    private static int dfs(Node curr, int sum) {
        if (curr.nodes == null) { // used when neighbour is processed from recursion.
            sum += curr.val;
            return sum;
        }
        for (Node next : curr.nodes) {
            if (!next.visited) {
                next.visited = true;
                if (next.nodes == null) {
                    sum += next.val;
                } else {
                    for (Node neighbour : next.nodes) {
                        sum = dfs(neighbour, sum);
                    }
                }
            }
        }
        return sum;
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
