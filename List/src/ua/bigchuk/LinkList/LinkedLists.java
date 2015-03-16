package ua.bigchuk.LinkList;

public class LinkedLists {

	private Lists last;
	private Lists first;
	private Lists current;

	private Integer indx = -1;
	private Integer counter = 0;

	public void add(Object val) {

		Lists data = this.new Lists();

		if (counter == 0) {

			first = data;
			last = data;
			current = data;
			data.val = val;
		}

		if (counter > 0) {

			indx = counter - 1;
			current = last;
			current.next = data;
			data.prev = current;
			current = data;
			last = data;
			data.val = val;
		}

		indx++;
		counter++;

	}// add

	public void add(Integer indx, Object val) {

		Lists data = this.new Lists();

		if (counter == indx) {
			add(val);
			return;
		}

		if (indx < counter)

			travelList(indx);

		if (indx == 0) {

			first = data;

			data.next = current;
			current.prev = data;
			current = data;
			data.val = val;
			counter++;

		}

		if (indx > 0) {

			current.prev.next = data;
			data.prev = current.prev;
			data.next = current;
			current.prev = data;
			current = data;
			data.val = val;
			counter++;
		}

	}// add

	public Integer size() {
		return counter;
	}

	public Object get(Integer indx) {

		travelList(indx);

		return current.val;
	}

	private void travelList(Integer indx) {

		if ((indx < counter) && (indx >= 0)) {

			if (this.indx > indx)
				while (this.indx != indx)
					prev();

			if (this.indx < indx)
				while (this.indx != indx)
					next();

		}// if
		else {
			System.out.print("за массивом");
		}

	}

	private void prev() {

		if (counter == 1) {
			current = last;
			indx--;
			return;
		}
		if (counter > 1)
			current = current.prev;
		indx--;
	}

	private void next() {

		if (counter == 0) {
			current = first;
		}
		if (counter > 0)
			current = current.next;

		indx++;
	}

	private class Lists {

		private Object val;

		private Lists next;
		private Lists prev;

	}// class

	public static void main(String[] args) {

		LinkedLists test = new LinkedLists();
		// for (int i = 0; i < 3; i++)
		test.add(0);
		test.add(1);
		test.add(1, 999);
		test.add(777);
		test.add(4, 9991);

		// System.out.println(test.indx);

		test.add(0, 444);
		test.add(3, 445);
		test.add(6, 446);

		test.add("fir");
		test.add(7, "seven");
		test.add(0, "null");

		for (int i = 0; i < test.size(); i++)
			System.out.println(test.get(i));

		System.out.println("size " + test.size());

	}// main

}// outer
