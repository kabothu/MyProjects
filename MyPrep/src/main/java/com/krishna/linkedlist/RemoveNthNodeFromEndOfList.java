package com.krishna.linkedlist;


//https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/

//https://www.youtube.com/watch?v=XtYEEvrhemI
class RemoveNthNodeFromEndOfListSolution {

	/*
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode fast = dummy;
	    ListNode slow = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        fast = fast.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (fast != null) {
	    	fast = fast.next;
	        slow = slow.next;
	    }
	    slow.next = slow.next.next;
	    return dummy.next;
	}*/
}

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
