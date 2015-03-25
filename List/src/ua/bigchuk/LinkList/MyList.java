package ua.bigchuk.LinkList;

import java.util.*;

public class MyList {

	private Data first;

	public void add(Object val) {

		Data add = new Data();
		Data current = null;

		if (first == null) {
			first = add;
			first.val = val;
			return;
		}

		if (first != null) {
			current = last();

			add.prev = current;
			current.next = add;
			add.val = val;
		}

	}

	private Data last() {

		Data current = first;
		while (current.next != null)
			current = current.next;

		return current;
	}

	public Object getLast() {

		return last().val;
	}

	public int size() {

		Data current = first;
		int size = 0;
		while (current != null) {
			current = current.next;
			size++;
		}

		return size;
	}

	public Object get(int indx) {

		Data current = first;

		int indxcount = 0;
		while (indxcount != indx) {
			current = current.next;
			indxcount++;
		}

		return current.val;
	}

	private class Data {

		private Object val;

		private Data next;
		private Data prev;

	}// class

	public static void main(String[] args) {

		long testL = -System.currentTimeMillis();

		// LinkedList test=new LinkedList();
		MyList test = new MyList();
		
		for (int i = 0; i < 10001; i++)
			test.add(i);

		for (int i = 0; i < test.size(); i++)
			// System.out.println(
			test.get(i);// );

		
		testL += System.currentTimeMillis();
		System.out.println(testL);

		// System.out.println(test.last().prev.val);

	}// main

}
