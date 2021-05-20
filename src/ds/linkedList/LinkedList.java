package ds.linkedList;

import java.util.NoSuchElementException;

/**
 * Custom Linked List Class
 * @author macho
 *
 */
public class LinkedList {
	/*
	 * Internal Node class to represent each link of the list
	 * @author macho
	 *
	 */
	private class Node {
		private int value;
		private Node next;
		public Node(int value) {
			this.value = value;
		}
		
	}

	/*
	 * field to keep track of first and last elements of list
	 */
	private Node first;
	private Node last;
	
	/*
	 * To keep track of size of list
	 */
	private int size;
	
	/*
	 * addLast method - To add a new node element to end of List
	 */
	public void addLast(int item) {
		Node node = new Node(item);
		
		if(isEmpty()) {
			//empty Linked List
			first = last = node;
		} else {
			//link new node to end of the list
			last.next=node;
			//update the last node to new node
			last=node;
		}
		
		size++; // To keep track of size of list
	}
	
	/*
	 * AddFirst method - To add a new node element to begining of th elist 
	 */
	public void addFirst(int item) {
		Node node = new Node(item);
		
		if(isEmpty()) {
			//empty list
			first = last = node;
		}else {
			//make new node's next element become existing first node
			node.next = first;
			//update first node to be new node
			first = node;
		}

		size++; // To keep track of size of list
	}
	
	/*
	 * Helper method to check if list is empty (if first == null)
	 */
	private boolean isEmpty() {
		return first == null;
	}
	
	/*
	 * Return index of the item
	 */
	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while(current!=null) {
			
			if(current.value==item) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}
	
	/*
	 * Method to check if list contains an item
	 */
	public boolean contains(int item) {
		/*Node current = first;
		while(current!=null) {
			if(current.value == item) {
				return true;
			}
			current=current.next;
		}
		return false;*/
		/* As the above code is same as indexOf(), indexOf can be directly used*/
		return indexOf(item)!=-1;
	}
	
	/*
	 * Remove first item from list
	 */
	public void removeFirst() {
		/* first = first.next; */ //This code works, but it does not get first node garbage collected
		/* Improved code wrt garbage collection*/

		if(isEmpty()) {
			//Just in case list is empty, throw custom exception than null poiner from below code
			throw new NoSuchElementException();
		}
		
		//If there is only 1 element in list
		if(first == last) {
			first = last = null;
		}else {
		
		//If list has 2 or more elements
		Node second = first.next;
		first.next=null;
		first = second;
		}
		
		size--; // To keep track of size of list

	}
	
	public void removeLast() {
		
		if(isEmpty()) {
			//If list is empty , nothing to remove
			throw new NoSuchElementException();
		}
		
		//If there s only 1 element in list
		if(first == last) {
			first = last = null;
		}else {
		
		//If list has 2 or more elemens
		//Get the prev to last node
		Node prev = getPrevious(last);
		//set last node to the prev node
		last = prev;
		//remove the link from prev to last node 
		last.next = null;
		}
		
		size--; // To keep track of size of list
	}
	
	/*
	 * Helper method - Returns previous node to given node
	 */
	private Node getPrevious(Node node) {
		Node current = first;
		while(current!=null) {
			if(current.next == node) {
				return current;
			}
			current=current.next;
		}
		
		//fail-safe, if the node is not found
		return null;
	}
	
	/*
	 * Method to return size of the list
	 */
	public int size() {
		/*
		Node current = first;
		while(current!=null) {
			size++;
			current = current.next;
		}
		return size;
		 */
		
		/*  Above code loops through the list to get size 
		 * 			-- but this can be done in better way by maintaing the size attribute in every add and remove method
		 * */
		return size;
	}
	
	/*
	 * Convert a linkedList to array
	 */
	public int[] toArray() {
		int[] array = new int[size];

		Node current = first;
		int index = 0;
		
		while(current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		return array;
	}
	
	/*
	 * Reverse a LinkedList
	 */
	public void reverse() {
		
		//corner case - if list is empty
		if(isEmpty()) {
			return;
		}
		
		/** logic to reverse starts here */
		// Takes 1st node as prev
		Node previous = first;
		//Take 2nd node as current
		Node current = first.next;
		//till we reach last node
		while(current != null) {
			//Save the next node to use once we make current node point to previous node
			Node next = current.next;
			//make current node point to previous node
			current.next = previous;
			
			/** step the loop forward*/ //below 2 must be in same order
			//change previous node to current node
			previous = current;
			//change current node to next node
			current = next;
		}
		/** logic to reverse till here ends */
		
		/** Now make the first and last point to new nodes*/
		last = first;
		last.next = null;
		first = previous;
		
	}
	
	/*
	 * Get kth element from end
	 * Approach - Two Pointers
	 * 1st Pointer to the start
	 * 2nd Pointer to k-1 node
	 * step through both the pointers untill 2nd'pointer is last elem
	 * 								(or 2nd pointer's next is null)
	 * In the end, we are left with required node in 1st pointer 
	 */
	public int getKthFromTheEnd(int k) {
		
		//check for empty list
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		//Intializing both pointers
		Node current = first;
		Node next = first;

		//setting 2nd pointer to k-1 node
		for(int i=0 ; i<k-1; i++) {
			next = next.next;
			//check if the kth element is out of bounds of list
			if(next == null) {
				throw new IllegalArgumentException();
			}
		}

		//looping till 2nd pointer reaches end
		while(next != last) {
			//just simple stepping through both pointers
			current = current.next;
			next = next.next;
		}

		//the 1st pointer is pointing to required node
		return current.value;
	}
}
