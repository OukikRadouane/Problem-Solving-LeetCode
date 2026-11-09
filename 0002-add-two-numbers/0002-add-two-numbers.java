/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int carry = 0;
       ListNode result = new ListNode();
       ListNode head = result;
       while(l1 != null || l2 != null || carry != 0){
        int num1 = l1 != null ? l1.val:0;
        int num2 = l2 != null ? l2.val:0;
        int sum = num1 + num2 + carry;
        carry = (sum) / 10;
        result.next = new ListNode((sum) % 10);
        l1 = (l1 != null) ? l1.next:null;
        l2 = (l2 != null)?l2.next:null;
        result = result.next;
       }
       return head.next;
    }
}