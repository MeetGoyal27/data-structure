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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode head : lists){
            if(head != null){
                pq.offer(head);
            }
        }
        while(pq.size()>0){
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null){
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}