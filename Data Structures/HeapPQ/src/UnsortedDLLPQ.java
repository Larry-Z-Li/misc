
//DLLPQ = Doubly Linked List Priority Queue	

public class UnsortedDLLPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {
	private ListNode2 queueHead;
	private int objectCount;
	
	public UnsortedDLLPQ()
	{
		queueHead = null;
		objectCount = 0;
	}
	
	public void add(E obj)
	{
		ListNode2 tommyboy = new ListNode2(obj);
		if(objectCount==0) {
			queueHead = tommyboy;
			queueHead.setNext(queueHead);
			queueHead.setPrevious(queueHead);
		}
		else
		{
			ListNode2 temp = queueHead.getPrevious();
			queueHead.setPrevious(tommyboy);
			tommyboy.setNext(queueHead);
			temp.setNext(tommyboy);
			tommyboy.setPrevious(temp);
		}
	
		objectCount++;	
	}
	
	public E removeMin()
	{
		if(isEmpty()) {
			System.out.println("Ouchy");
			return null;
		}
		else if(objectCount==1) {
			E temp = (E)queueHead.getValue();
			queueHead=null;
			objectCount--;
			return temp;
		}
		else {
			ListNode2 min = queueHead;
			ListNode2 check = queueHead;
			for(int i = 1; i < objectCount; i++) {
				check=check.getNext();
				if(((E)min.getValue()).compareTo((E)check.getValue())>0)
					min = check;
			}
			min.getPrevious().setNext(min.getNext());
			min.getNext().setPrevious(min.getPrevious());
			objectCount--;
			return (E)min.getValue();
		}
	}
	
	public E peek()
	{
		if(objectCount==0)
			return null;
		else if(objectCount==1) {
			return (E)queueHead.getValue();
		}
		else {
			ListNode2 min = queueHead;
			for(ListNode2 check = queueHead.getNext(); check != queueHead; check = check.getNext()) {
				if(((E)min.getValue()).compareTo((E)check.getValue()) > 0)
					min = check;
			}
			return (E)min.getValue();
		}
	}
	
	public boolean isEmpty()
	{
		return (objectCount==0);
	}
	
	public int size()
	{
		return objectCount;
	}
	
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer ("[ ");
		for (ListNode2 node = queueHead; node != null; node = node.getNext()) 
		{
			stringbuf.append(node.getValue()+" ");

		}
		stringbuf.append("]");
		return stringbuf.toString();
	}
}