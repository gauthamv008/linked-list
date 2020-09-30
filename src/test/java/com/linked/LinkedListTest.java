/**
 * 
 */
package com.linked;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author gowtham.v
 *
 * 30-Sep-2020 6:06:58 pm
 */
public class LinkedListTest {

	@Test
	public void test() {
		int[] expected = {45, 15, 91, 3, 65, 20, 88, 24, 2, 22};
		int[] keys = { 45, 20, 15, 88, 91, 24, 3, 2, 65, 22 };
		Node head = null;
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new Node(keys[i], head);
		}

		head = LinkedList.rearrangeOddEven(head);
		assertNotNull("Node is empty or null",head);
		
		int actual[] = getNodeValues(head, keys.length);
		
		System.out.println("Expected value : "+ Arrays.toString(expected));
		System.out.println("Actual value : "+ Arrays.toString(actual));
		
		assertNotEquals("Actual and Excepted is not matching!!!", expected, actual);
	}

	public static int[] getNodeValues(Node head, int size){

		Node ptr = head;

		int[] actual = new int[size];
		int i = 0;
		while (ptr != null)
		{
			actual[i++] = ptr.data;
			ptr = ptr.next;
		}

		return actual;
	}
}
