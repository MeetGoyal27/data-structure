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
    public int findLength(ListNode head){
        int count=0;
        ListNode curr = head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        int len = findLength(head);
        if(len == n){
            return head.next;
        }
        ListNode curr = head;
        for(int i=0;i<len-n-1;i++){
            curr=curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}