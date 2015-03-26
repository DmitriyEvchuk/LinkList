package ua.bigchuk.LinkList;

import java.util.*;

public class MyList {

	private Data first;

	public void add(Object val) {

		Data add = new Data();

		if (first == null) {
			first = add;

		}

		else {

			Data current = null;
			current = last();
			add.prev = current;
			current.next = add;

		}

		add.val = val;

	}

	public void add(int indx, Object val) {

		Data add = new Data();

		if (indx == 0) {

			add.next = first;
			first = add;

		} else {

			int size = size();

			if (indx < size) {

				Data current = getForIndx(indx);

				add.next = current;
				add.prev = current.prev;
				current.prev.next = add;

			} else if (indx == size) {
				add(val);

			} else
				System.out.println("за пределами");

		}

		if (add.val == null)

			add.val = val;

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

		return getForIndx(indx).val;
	}

	private Data getForIndx(int indx) {

		Data current = first;

		int indxcount = 0;
		while (indxcount != indx) {
			current = current.next;
			indxcount++;
		}

		return current;
	}

	private Data last() {

		Data current = first;
		while (current.next != null)
			current = current.next;

		return current;
	}

	private class Data {

		private Object val;

		private Data next;
		private Data prev;

	}// class

	public static void main(String[] args) {

		
		MyList test = new MyList();

		for (int i = 0; i < 10; i++)
			test.add(i);

		test.add(5, "d1");
		test.add(0, "d2");
		test.add(11, "d3");
		test.add(14, "d4");

		for (int i = 0; i < test.size(); i++)
			System.out.println(test.get(i));// );

		
		//System.out.println(test.getForIndx(11).prev.val);
		 

		// System.out.println(test.last().prev.val);

	}// main

}
