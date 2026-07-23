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

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add all node values to the priority queue
        for (ListNode temp : lists) {
            while (temp != null) {
                pq.add(temp.val); // Add the node's value to the priority queue
                temp = temp.next;  // Move to the next node
            }
        }

        // Create a dummy node to simplify merging the linked list
        ListNode temp = new ListNode();
        ListNode point = temp; // Pointer to the head of the merged list

        // Build the merged linked list from the priority queue
        while (!pq.isEmpty()) {
            ListNode newNode = new ListNode(pq.poll());  // Poll the smallest value from the priority queue
            temp.next = newNode;  // Attach it to the result list
            temp = temp.next;     // Move to the next node
        }

        return point.next;  // Return the merged list (skip the dummy node)
    }
}
