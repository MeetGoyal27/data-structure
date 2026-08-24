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
        ListNode h1 = l1;
        ListNode h2 = l2;
        int carry=0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(h1!=null || h2!=null || carry>0){
            int val1 = (h1==null)?0:h1.val;
            int val2 = (h2==null)?0:h2.val;
            int sum = val1+val2+carry;
            ListNode node = new ListNode(sum%10);
            curr.next = node;
            curr = curr.next;
            carry = sum/10;
            if(h1!=null){
                h1 = h1.next;
            }
            if(h2!=null){
                h2=h2.next;
            }
        }
        return dummy.next;
    }
}