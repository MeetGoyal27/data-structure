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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        int c = 0;
        while(temp != null && c<k){
            temp = temp.next;
            c++;
        }
        if(c<k){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        for(int i=0;i<k;i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKGroup(curr,k);
        return prev;
    }
}