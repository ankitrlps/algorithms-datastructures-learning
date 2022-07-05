package learning.algorithms;

public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        while (head != null) {
            Node next_node = head.next;
            head.next = prev;
            prev = head;
            head = next_node;
        }
        return prev;
    }

    private static void printNodes(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        System.out.println("Before reversing: ");
        printNodes(head);
        System.out.println("\nAfter reversing: ");
        printNodes(reverseLinkedList(head));
    }    
}
