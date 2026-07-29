/**
 * Problem: Segregate Evens and Odds in a Linked List

 * Platform: GFG
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: take four pointers for odd and even heads and tails and move its tail according to even and odd , and initializing its tail to head

 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    Node divide(Node head) {
        // code here
        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;
        
        Node curr = head;
        
        while(curr != null){
            if(curr.data % 2 == 0){
                if(evenHead == null){
                    evenHead = curr;
                    evenTail = evenHead;
                }else{
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            }else{
                if(oddHead == null){
                    oddHead = curr;
                    oddTail = oddHead;
                }else{
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            curr = curr.next;
            
        }
            if(evenHead == null) return oddHead;
            if(oddHead == null) return evenHead;
        
            evenTail.next = oddHead;
            oddTail.next = null;
            return evenHead;
    }   
}
