/**
 * 
 */
package com.linked;

/**
 * @author gowtham.v
 *
 * 30-Sep-2020 6:00:52 pm
 */
public class LinkedList {

	public static void main(String[] args){

		int[] keys = { 45, 20, 15, 88, 91, 24, 3, 2, 65, 22 };
		Node head = null;
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new Node(keys[i], head);
		}

		head = rearrangeOddEven(head);
		printList(head);
	}


	public static Node rearrangeOddEven(Node head){
		Node odd = null, oddTail = null;
		Node even = null, evenTail = null;
		Node curr = head;

		while (curr != null)
		{
			if ((curr.data & 1) != 0) // current node is odd
			{
				// handle head for first odd node
				if (odd == null) {
					odd = oddTail = curr;
				}
				else
				{
					oddTail.next = curr;
					oddTail = oddTail.next;
				}
			}else // current node is even
			{
				// handle head for first even node
				if (even == null) {
					even = evenTail = curr;
				}
				else
				{
					evenTail.next = curr;
					evenTail = curr;
				}
			}
			curr = curr.next;
		}

		// if list contains at-least one odd node
		if (odd != null)
		{
			head = odd;
			oddTail.next = even;
		}
		// special case - list contains all even nodes
		else {
			head = even;
		}

		// null to terminate the list,
		// else it will go in infinite loop
		if (evenTail != null) {
			evenTail.next = null;
		}

		return head;
	} 

	public static void printList(Node head){

		Node ptr = head;
		while (ptr != null)
		{
			System.out.print(ptr.data + ", ");
			ptr = ptr.next;
		}

		System.out.println("null");
	}

}
