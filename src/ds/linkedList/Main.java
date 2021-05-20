package ds.linkedList;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		System.out.println(list.size());

		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		
		/*
		 * System.out.println(list.size());
		 * 
		 * list.removeFirst(); System.out.println(list.size());
		 * 
		 * list.removeLast(); System.out.println(list.size());
		 * 
		 * list.removeFirst(); System.out.println(list.size());
		 */		
		
		System.out.println(Arrays.toString(list.toArray()));

		System.out.println(list.getKthFromTheEnd(0));
	}

}
