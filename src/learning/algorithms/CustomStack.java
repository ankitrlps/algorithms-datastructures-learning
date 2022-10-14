package learning.algorithms;


/**
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/
 * 
 * Input
["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
Output
[null,null,null,2,null,null,null,null,null,103,202,201,-1]
Explanation
CustomStack customStack = new CustomStack(3); // Stack is Empty []
customStack.push(1);                          // stack becomes [1]
customStack.push(2);                          // stack becomes [1, 2]
customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
customStack.push(2);                          // stack becomes [1, 2]
customStack.push(3);                          // stack becomes [1, 2, 3]
customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
customStack.increment(5, 100);                // stack becomes [101, 102, 103]
customStack.increment(2, 100);                // stack becomes [201, 202, 103]
customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
customStack.pop();                            // return -1 --> Stack is empty return -1.
 */

public class CustomStack {
    
    class CusList {
        CusList next;
        CusList prev;
        int val;
        public CusList() {
            this.next = this.prev = null;
        }
        public CusList(int val) {
            this.next = this.prev = null;
            this.val = val;
        }
    }
    
    CusList head;
    CusList tail;
    int capacity;
    int size;

    public CustomStack(int maxSize) {
        this.capacity = maxSize;
        this.size = 0;
        this.head = new CusList();
        this.tail = new CusList();
        tail.prev = head;
        head.next = tail;
    }
    
    public void push(int x) {
        if (size == capacity) return;
        CusList node = new CusList(x);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }
    
    public int pop() {
        if (size == 0) return -1;
        CusList node = head.next;
        head.next.next.prev = head.next;
        head.next = head.next.next;
        size--;
        return node.val;
    }
    
    public void increment(int k, int val) {
        if (size == 0) return;
        CusList node = tail.prev;
        while (k > 0 && node != null) {
            node.val += val;
            node = node.prev;
            k--;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
        customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
        customStack.pop();                            // return -1 --> Stack is empty return -1.
    }
}
