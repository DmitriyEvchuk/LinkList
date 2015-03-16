package ua.bigchuk.LinkList;

public class LinkedLists {

	private Lists last;
	private Lists first;
	private Lists current;

	private Integer indx = -1;
	private Integer counter = 0;

	public void add(Object val) {

		counter++;
		Lists current = this.new Lists();

		if (counter == 1)
			first = current;

		current.val = val;

		if (last != null) {
			last.next = current;
			current.prev = last;
		}

		last = current;
		
	}// add

	public void add(Integer indx, Object val) {

		Lists data = this.new Lists();
		if ((indx >= 0) && (indx < counter)) {// if0

			travelList(indx);

			if ((indx == 0) && (counter > 0)) {

				data.next = current;
				current.prev = data;
			}

			if (indx > 0) {

				data.next = current;
				data.prev = current.prev;
				current.prev.next = data;
				current.prev = data;

			}
			data.val = val;

			
			current = data;
			counter++;
		}// if0

		if (indx == counter) {// if1
	add(val);

	}// if1

	}// add

	public Integer size() {
		return counter;
	}

	public Object get(Integer indx) {

		travelList(indx);
//System.out.println("ddddd"+this.indx+indx);
		return current.val;
	}

	private void travelList(Integer indx) {

		if ((indx < counter) && (indx >= 0)) {

			if ((this.indx == -1) && ((counter / 2) >= indx))
				while (this.indx != indx)
					next();

			if ((this.indx == -1) && ((counter / 2) < indx))
				while (this.indx != indx)
					prev();

			if (this.indx > indx) {// 0

				if ((this.indx / 2) <= indx)
					while (this.indx != indx)
						prev();

				if ((this.indx / 2) > indx)
					this.indx = -1;
				while (this.indx != indx)
					next();

			}// if0
			if (this.indx < indx) {// 1

				int size = counter - this.indx;
				int halfSize = (size / 2) + this.indx;// 8

				if (halfSize <= indx) {
					this.indx = -1;
					while (this.indx != indx)
						prev();
				}

				if (halfSize > indx)
					while (this.indx != indx)
						next();

			}// if1
		}// if

	}

	private void prev() {

		if (indx == (-1)) {
			current = last;
			indx = (counter - 1);
			return;
		}
		if (indx > 0)
			current = current.prev;
		indx--;
	}

	private void next() {

		indx++;
		if (indx == 0) {
			current = first;
		}
		if ((indx > 0) && (indx < counter))
			current = current.next;

	}

	private class Lists {

		private Object val;

		private Lists next;
		private Lists prev;

	}// class

	public static void main(String[] args) {

		LinkedLists test = new LinkedLists();
		for (int i = 0; i < 12; i++)
			test.add(i);
		
		test.add(1,"first");
		test.add(7,"seven");
		//test.add(0,"null");
		
		for (int i = 0; i < test.size(); i++)
		System.out.println(test.get(i));
		
		//System.out.println(test.get(0));
		

		System.out.println("size " + test.size());

	}// main

}// outer
