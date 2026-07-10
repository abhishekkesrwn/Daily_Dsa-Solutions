/**
 * Problem: Add Two Numbers
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: traverse the linked list 
 * Solve Type: Self
 *
 * Key Insight: create dummy node if l1 or l2 become null take its val 0. move l1 and l2 if they are not pointing to null. 
                 loop terminates when both l1 and l2 null and no carry. if carry take both value 0 create new node for carry

 * Time: O(N)
 * Space: O(1)
 */
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
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        int carry = 0;

        while(l1 != null || l2 != null){
            int x = l1!= null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x+y + carry;
            carry = sum/10 ;
            ListNode newNode = new ListNode(sum % 10);
            
            curr.next = newNode;
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        return dummyNode.next;
    }
}
