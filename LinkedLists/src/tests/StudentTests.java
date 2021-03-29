package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

public class StudentTests {

	@Test
	public void basicLinkedListConstructor() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();

		assertTrue(b1.getFirst() == null);
		assertTrue(b1.getLast() == null);
		assertTrue(b1.getSize() == 0);
	}

	@Test
	public void basicLinkedListGetSize() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();

		assertTrue(b1.getSize() == 0);

		b1.addToEnd(83002);

		assertTrue(b1.getSize() == 1);

		b1.addToEnd(9);

		assertTrue(b1.getSize() == 2);
	}

	@Test
	public void basicLinkedListGetFirst() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();

		assertTrue(b1.getFirst() == null);

		b1.addToFront(4782);

		assertTrue(b1.getFirst() == 4782);

		b1.addToFront(8);

		assertTrue(b1.getFirst() == 8);
	}

	@Test
	public void basicLinkedListGetLast() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();

		assertTrue(b1.getLast() == null);

		b1.addToFront(4782);

		assertTrue(b1.getLast() == 4782);

		b1.addToFront(8);

		assertTrue(b1.getLast() == 4782);
	}

	@Test
	public void basicLinkedListAddToFront() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();

		b1.addToFront(5);
		b1.addToFront(8);
		b1.addToFront(200);

		assertTrue(b1.getFirst() == 200);
		assertTrue(b1.getLast() == 5);
		assertTrue(b1.getSize() == 3);

		BasicLinkedList<Integer> b2 = new BasicLinkedList<Integer>();

		b2.addToFront(200);

		assertTrue(b2.getLast() == 200 && b2.getFirst() == 200);
		assertTrue(b2.getSize() == 1);
	}

	@Test
	public void basicLinkedListAddToEnd() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();

		b1.addToEnd(5);
		b1.addToEnd(8);
		b1.addToEnd(200);

		assertTrue(b1.getFirst() == 5);
		assertTrue(b1.getLast() == 200);
		assertTrue(b1.getSize() == 3);

		BasicLinkedList<Integer> b2 = new BasicLinkedList<Integer>();

		b2.addToEnd(200);

		assertTrue(b2.getLast() == 200 && b2.getFirst() == 200);
		assertTrue(b2.getSize() == 1);
	}

	@Test
	public void basicLinkedListRetrieveFirstElement() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();

		b1.addToFront(5);
		b1.addToEnd(8);
		b1.addToEnd(200);

		assertTrue(b1.retrieveFirstElement() == 5);
		assertTrue(b1.getFirst() == 8);
		assertTrue(b1.getLast() == 200);
		assertTrue(b1.getSize() == 2);

		BasicLinkedList<Integer> b2 = new BasicLinkedList<Integer>();

		b2.addToEnd(200);

		assertTrue(b2.retrieveFirstElement() == 200);
		assertTrue(b2.getSize() == 0);
		assertTrue(b2.getLast() == null && b2.getFirst() == null);
	}

	@Test
	public void basicLinkedListRetrieveLastElement() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();

		b1.addToFront(5);
		b1.addToEnd(8);
		b1.addToEnd(200);

		assertTrue(b1.retrieveLastElement() == 200);
		assertTrue(b1.getFirst() == 5);
		assertTrue(b1.getLast() == 8);
		assertTrue(b1.getSize() == 2);

		BasicLinkedList<Integer> b2 = new BasicLinkedList<Integer>();

		b2.addToEnd(200);

		assertTrue(b2.retrieveLastElement() == 200);
		assertTrue(b2.getSize() == 0);
		assertTrue(b2.getLast() == null && b2.getFirst() == null);
	}

	@Test
	public void basicLinkedListIterator() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();
		String answer = "";

		b1.addToFront(5);
		b1.addToEnd(8);
		b1.addToEnd(200);

		for (Integer i : b1) {
			answer += i.toString();
		}

		assertTrue(b1.iterator().hasNext());
		assertTrue(b1.iterator().next() == 5);
		assertTrue(answer.equals("58200"));
	}

	@Test
	public void basicLinkedListRemove() {
		BasicLinkedList<String> b1 = new BasicLinkedList<String>();

		b1.addToFront("Hello");
		b1.addToEnd("Wow");
		b1.addToEnd("Bye");
		b1.addToEnd("Wow");
		b1.addToEnd("Wow");
		b1.remove("Wow", String.CASE_INSENSITIVE_ORDER);

		assertTrue(b1.getFirst().equals("Hello"));
		assertTrue(b1.getLast().equals("Bye"));
		assertTrue(b1.getSize() == 2);

		BasicLinkedList<String> b2 = new BasicLinkedList<String>();

		b2.addToEnd("Nice");
		b2.remove("Nice", String.CASE_INSENSITIVE_ORDER);

		assertTrue(b2.getSize() == 0);
		assertTrue(b2.getLast() == null && b2.getFirst() == null);
	}

	@Test
	public void basicLinkedListGetReverseArrayList() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();
		String b1Answer = "";
		String a1Answer = "";

		b1.addToFront(5);
		b1.addToEnd(8);
		b1.addToEnd(200);

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1 = b1.getReverseArrayList();

		for (Integer i : b1) {
			b1Answer += i.toString();
		}

		assertTrue(b1Answer.equals("58200"));

		for (Integer i : a1) {
			a1Answer += i.toString();
		}

		assertTrue(a1Answer.equals("20085"));
	}

	@Test
	public void basicLinkedListGetReverseList() {
		BasicLinkedList<Integer> b1 = new BasicLinkedList<Integer>();
		String b1Answer = "";
		String b2Answer = "";

		b1.addToFront(5);
		b1.addToEnd(8);
		b1.addToEnd(30);
		b1.addToEnd(72);

		BasicLinkedList<Integer> b2 = new BasicLinkedList<Integer>();
		b2 = b1.getReverseList();

		for (Integer i : b1) {
			b1Answer += i.toString();
		}

		assertTrue(b1Answer.equals("583072"));

		for (Integer i : b2) {
			b2Answer += i.toString();
		}

		assertTrue(b2Answer.equals("723085"));
	}

	@Test
	public void sortedLinkedListConstructor() {
		SortedLinkedList<String> s1 = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);

		assertTrue(s1.getFirst() == null);
		assertTrue(s1.getLast() == null);
		assertTrue(s1.getSize() == 0);
	}

	@Test
	public void sortedLinkedListAdd() {
		SortedLinkedList<String> s1 = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		String answer = "";

		s1.add("Faucet");
		s1.add("Love");
		s1.add("Fire");

		for (String s : s1) {
			answer += s + " ";
		}

		assertTrue(answer.equals("Faucet Fire Love "));
		assertTrue(s1.getSize() == 3);
	}

	@Test
	public void sortedLinkedListRemove() {
		SortedLinkedList<String> s1 = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		String answer = "";

		s1.add("Fire");
		s1.add("Faucet");
		s1.add("Love");
		s1.add("Fire");
		s1.remove("Fire");

		for (String s : s1) {
			answer += s + " ";
		}

		assertTrue(answer.equals("Faucet Love "));
		assertTrue(s1.getSize() == 2);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void sortedLinkedListAddToEnd() {
		SortedLinkedList<String> s1 = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);

		s1.addToEnd("Authority is worn over your clothes.");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void sortedLinkedListAddToFront() {
		SortedLinkedList<String> s1 = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);

		s1.addToFront("When we hit our lowest point, we are open to the greatest change.");
	}

}
