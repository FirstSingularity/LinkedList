package listClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class BasicLinkedList<T> implements Iterable<T> {

	protected Node head;
	protected Node tail;
	protected int size;

	public BasicLinkedList() {
		size = 0;
	}

	protected class Node {
		T data;
		Node next;

		Node(T d) {
			data = d;
			next = null;
		}
	}

	public int getSize() {
		int privacyLeakBlock = this.size;
		return privacyLeakBlock;
	}

	public T getFirst() {
		if (size == 0) {
			return null;
		}
		return this.head.data;
	}

	public T getLast() {
		if (size == 0) {
			return null;
		}
		return this.tail.data;
	}

	public BasicLinkedList<T> addToFront(T data) {
		Node n = new Node(data);

		n.next = this.head;
		this.head = n;
		this.size++;

		if (this.size == 1) {
			this.tail = this.head;
		}
		return this;
	}

	public BasicLinkedList<T> addToEnd(T data) {
		Node n = new Node(data);

		if (this.size == 0) {
			this.tail = n;
		} else {
			this.tail.next = n;
			this.tail = n;
		}
		this.size++;

		if (this.size == 1) {
			this.head = this.tail;
		}
		return this;
	}

	public T retrieveFirstElement() {
		if (size == 0) {
			return null;
		}
		T answer = this.head.data;

		if (this.head.next != null) {
			this.head = this.head.next;
		} else {
			this.head = null;
			this.tail = this.head;
		}
		this.size--;

		return answer;
	}

	public T retrieveLastElement() {
		if (size == 0) {
			return null;
		}
		T answer = this.tail.data;

		if (this.size == 1) {
			this.tail = null;
			this.head = this.tail;
		} else {
			Node current = this.head;

			while (current.next.next != null) {
				current = current.next;
			}
			this.tail = current;
		}
		this.size--;

		return answer;
	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {

			Node current = head;

			@Override
			public boolean hasNext() {
				if (current == null) {
					return false;
				}
				return true;
			}

			@Override
			public T next() {
				if (hasNext()) {
					T data = current.data;
					current = current.next;

					return data;
				}
				return null;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Remove not implemented.");
			}
		};
	}

	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		int removed = 0;

		while (comparator.compare(this.head.data, targetData) == 0) {
			this.head = this.head.next;
			removed++;
			if (this.size - removed == 0) {
				this.size -= removed;
				return this;
			}
		}

		Node behind = this.head;
		Node ahead = behind.next;

		while (ahead != null) {
			if (comparator.compare(ahead.data, targetData) == 0) {
				ahead = ahead.next;
				removed++;
			} else {
				behind.next = ahead;
				ahead = ahead.next;
				behind = behind.next;
			}
		}
		behind.next = null;
		this.size -= removed;

		Node current = this.head;

		while (current.next != null) {
			current = current.next;
		}
		this.tail = current;

		return this;
	}

	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> reversedArrayList = new ArrayList<T>();
		BasicLinkedList<T> reversed = getReverseList();

		Node current = reversed.head;

		while (current != null) {
			reversedArrayList.add(current.data);
			current = current.next;
		}

		return reversedArrayList;
	}

	public BasicLinkedList<T> getReverseList() {
		BasicLinkedList<T> reversed = new BasicLinkedList<T>();

		reversed.head = recursiveReverser(cloneList(this).head);

		Node current = reversed.head;

		while (current.next != null) {
			current = current.next;
		}
		reversed.tail = current;
		reversed.size = this.size;

		return reversed;
	}

	private Node recursiveReverser(Node current) {
		if (current == null || current.next == null) {
			return current;
		}

		Node rev = recursiveReverser(current.next);

		current.next.next = current;
		current.next = null;

		return rev;
	}

	private BasicLinkedList<T> cloneList(BasicLinkedList<T> original) {
		if (this.size == 0) {
			return null;
		}

		BasicLinkedList<T> clone = new BasicLinkedList<T>();

		clone.head = new Node(this.head.data);

		if (this.size == 1) {
			return clone;
		}

		Node currentC = clone.head;
		Node currentO = this.head;

		while (currentO != null) {
			if (currentO != this.head) {
				Node add = new Node(currentO.data);
				currentC.next = add;
				currentC = currentC.next;
			}
			currentO = currentO.next;
		}
		clone.size = this.size;

		return clone;
	}
}
