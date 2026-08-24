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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode f = head;
        ListNode s = head;
        while(f!=null && f.next!=null){
            f = f.next.next;
            s=s.next;
        }
        ListNode newHead = s.next;
        s.next = null;
        ListNode prev=null;
        ListNode curr = newHead;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode l1 = head;
        ListNode l2 = prev;
        while(l2!=null){
            ListNode m1 = l1.next;
            ListNode m2 = l2.next;
            l1.next = l2;
            l2.next = m1;
            l1=m1;
            
            l2=m2;
        }
    }
}