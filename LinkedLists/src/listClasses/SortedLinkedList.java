package listClasses;

import java.util.Comparator;

public class SortedLinkedList<T> extends BasicLinkedList<T> {

	private Comparator<T> comparator;

	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	public SortedLinkedList<T> add(T element) {
		Node n = new Node(element);
		Node previous = null, current = head;

		if (head == null) {
			head = n;
			tail = n;
		} else if (this.comparator.compare(n.data, current.data) <= 0) {
			n.next = head;
			head = n;
		} else if (this.comparator.compare(n.data, tail.data) >= 0) {
			tail.next = n;
			tail = n;
		} else {
			while (this.comparator.compare(n.data, current.data) > 0) {
				previous = current;
				current = current.next;
			}
			previous.next = n;
			n.next = current;
		}
		size++;

		return this;
	}

	public SortedLinkedList<T> remove(T targetData) {
		super.remove(targetData, this.comparator);

		return this;
	}

	public BasicLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

	public BasicLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
}