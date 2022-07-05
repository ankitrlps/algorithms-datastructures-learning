package learning.algorithms;

public class AddTwoNumbersUsingLinkedList {

  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  static ListNode res = new ListNode();

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0);
    ListNode i = l1;
    ListNode j = l2;
    ListNode curr = res;
    int carry = 0;
    while (i != null || j != null) {
        int x = (i != null) ? i.val : 0;
        int y = (j != null) ? j.val : 0;
        int sum = x + y + carry;
        carry = sum/10;
        curr.next = new ListNode(sum%10);
        curr = curr.next;
        if (i != null) i = i.next;
        if (j != null) j = j.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return res.next;
}
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(node1, node2);
        
    }    
}
