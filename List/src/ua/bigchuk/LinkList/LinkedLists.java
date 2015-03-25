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

			if (this.indx > indx) {

				int half = this.indx / 2;

				if (half < indx) {

					while (this.indx != indx)
						prev();
				}
				if (half >= indx) {

					this.indx = 0;
					current = first;

					while (this.indx != indx)
						next();
				}

			}

			if (this.indx < indx) {

				int size = (counter - this.indx);
				int halfSize = (size / 2) + this.indx;

				if (halfSize > indx) {

					while (this.indx != indx)
						next();
				}

				if (halfSize <= indx) {

					this.indx = counter - 1;
					current = last;

					while (this.indx != indx)
						prev();
				}
			}

		} else {
		
			System.out.print("за массивом");
		}
	}

	private void prev() {

		current = current.prev;
		
		indx--;
	}

	private void next() {

		current = current.next;

		indx++;
	}

	private class Lists {

		private Object val;

		private Lists next;
		private Lists prev;

	}// class

	public static void main(String[] args) {

		long readT = -System.currentTimeMillis();
		LinkedLists test = new LinkedLists();
		for (int i = 0; i < 100; i++)
			test.add(i);

		
		for (int i = 0; i < 100; i++)
			test.get(i);
		readT += System.currentTimeMillis();
		 //System.out.println(test.get(5));
		System.out.println(readT);

	}// main

}// outer
