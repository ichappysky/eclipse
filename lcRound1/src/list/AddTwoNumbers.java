package list;

import common.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if (a==null) {
        	return b;
        }
        if (b==null) {
        	return a;
        }
        ListNode dummy = new ListNode(0);
        ListNode end = dummy;
        int carry = 0;
        while (a!=null || b!=null || carry>0) {
        	int cur = 0;
        	if (a!=null) {
        		cur = a.val;
        		a = a.next;
        	}
        	if (b!=null ) {
        		cur+=b.val;
        		b=b.next;
        	}
        	cur+= carry;
        	carry = cur/10;
        	cur = cur%10;
        	end.next = new ListNode (cur);
        	end = end.next;
        }
        
        return dummy.next;
    }
}