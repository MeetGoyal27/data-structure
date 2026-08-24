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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode curr = head;
        int len=1;
        while(curr.next!=null){
            curr=curr.next;
            len++;
        }
        curr.next = head;
        k=k%len;
        curr=head;
        for(int i=0;i<len-k-1;i++){
            curr=curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}