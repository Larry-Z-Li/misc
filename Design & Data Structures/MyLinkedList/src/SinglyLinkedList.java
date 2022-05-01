import java.util.ArrayList;

// Implements a singly-linked list.


public class SinglyLinkedList {
	private ListNode head;
	private ListNode tail;
	private int nodeCount;
	
	// Constructor: creates an empty list
	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(Object[] values) {
		ListNode foinalNoid = new ListNode(values[values.length-1]);
		ListNode address = foinalNoid;
		tail = address;
		nodeCount=1;
		for(int i = values.length-2; i >= 0; i--) {
			ListNode node = new ListNode(values[i], address);
			address = node;
			nodeCount++;
			if(i==0)
				head = node;
		}	
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(Object obj) {
		ListNode check = head;
		if(head!=null) {
		if(check.getValue().equals(obj))
			return true;
		for(int i = 0; i < nodeCount-1; i++) {
			check = check.getNext();
			if(check.getValue().equals(obj))
				return true;
		}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Object obj) {
		ListNode check = head;
		int index = 0;
		if(head != null) {
		if(check.getValue().equals(obj)) {
			return 0;
		}
		
		for(int i = 0; i < nodeCount-1; i++) {
			check = check.getNext();
			index++;
			if(check.getValue().equals(obj)) {
				return index;
			}
		}
		return -1;
		}
		
		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(Object obj) {
		ListNode node = new ListNode(obj);
		
		if(head!=null) {
			tail.setNext(node);
			tail = node;
		}
		else {
			head = node;
			tail = node;
		}
		nodeCount++;
		return true;
		
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Object obj) {
		if(head!=null) {
			ListNode store = head;
			ListNode check = head;
			if(check.getValue().equals(obj)) {
				check=check.getNext();
				head = check;
				nodeCount--;
				return true;
			}
			if(nodeCount < 2)
				return false;
			check=check.getNext();
			for(int i = 0; i < nodeCount-2; i++) {
				if(check.getValue().equals(obj)) {
					store.setNext(check.getNext());
					tail=store;
					nodeCount--;
					return true;
				}
				check=check.getNext();
				store=store.getNext();
			}
			if(check.getValue().equals(obj)) {
				check.setNext(null);
				tail=check;
				nodeCount--;
				return true;
			}
			return false;
				
				
		}
		else
			return false;
	}

	// Returns the i-th element.               
	public Object get(int i) {
		ListNode check = head;
		if(head!=null && i < nodeCount && i >= 0) {
			if(i==nodeCount-1) {
				return tail.getValue();
			}
			for(int ind = 0; ind < i; ind++) {
				check=check.getNext();
				
			}
			return check.getValue();
		}
		throw new IndexOutOfBoundsException("Oops you trod on a bad locale.");
	}

	// Replaces the i-th element with obj and returns the old value.
	public Object set(int i, Object obj) {
		if(i < nodeCount && i >= 0) {
			if(i==nodeCount-1) {
				Object temp = tail.getValue();
				tail.setValue(obj);
				return temp;
			}
			ListNode check = head;
			for(int ind = 0; ind < i; ind++) {
				check=check.getNext();
			}
			Object temp = check.getValue();
			check.setValue(obj);
			return temp;
		}
		else
			throw new IndexOutOfBoundsException("Oops you trod on a bad locale.");
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		ListNode check = head;
		ListNode node = new ListNode(obj);
		if(i==0) {
			node.setNext(head);
			head=node;
			nodeCount++;
		}
		else if(i < nodeCount && i >= 0) {
			for(int ind = 0; ind < i-1; ind++) {
				check=check.getNext();
			}
			node.setNext(check.getNext());
			check.setNext(node);
			nodeCount++;
		}
		else if(i==nodeCount)
			add(obj);
		else
			throw new IndexOutOfBoundsException("Oops you trod on a bad locale.");
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Object remove(int i) {
		ListNode check = head;
		ListNode store = head;
		if(i<nodeCount&&i>-1) {
			if(i==0 && nodeCount == 1) {
				head = null;
				tail = null;
				nodeCount--;
			}
			else if(i==0) {
				check=check.getNext();
				head=check;
				nodeCount--;
			}
			check=check.getNext();	
			for(int ind = 1; ind < i; ind++) {
				check=check.getNext();
				store=store.getNext();
			}
			
			store.setNext(check.getNext());
			Object temp = check.getValue();
			tail = store;
			nodeCount--;
			return temp;
			
		}
		else
			throw new IndexOutOfBoundsException("Oops you trod on a bad locale.");
	}
	
	

	// Returns a string representation of this list.
	public String toString() {
		String toReturn = "{";
		if(head!=null) {
		ListNode check = head;
		toReturn+=check.getValue() +", ";
		
		for(int i = 0; i < nodeCount - 2; i++) {
			check=check.getNext();
			toReturn+=check.getValue() + ", ";
		}
		check=check.getNext();
		toReturn += check.getValue() + "}";
		}
		else
			toReturn+="}";
		return toReturn;
	}

}
