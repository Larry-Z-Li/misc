
//SortedSLLPQ = Sorted Singly Linked List Priority Queue

public class SortedSLLPQ<E extends Comparable<E>> implements MyPriorityQueue<E> 
{
	private ListNode queueHead;
	private int objectCount;

	public SortedSLLPQ()
	{
		queueHead = null;
		objectCount = 0;
	}

	public void add(E obj)
	{
		ListNode tommyboy = new ListNode(obj);
		ListNode check = queueHead;
		ListNode trail = queueHead;
		boolean added = false;
		
		if(!isEmpty()) {
			if(obj.compareTo((E)check.getValue()) < 0) {
				added = true;
				tommyboy.setNext(queueHead);
				queueHead = tommyboy;
			}
			while(check.getNext()!=null && !added) {
				check=check.getNext();
				if(obj.compareTo((E)check.getValue()) < 0 && obj.compareTo((E)trail.getValue()) > 0) {
					trail.setNext(tommyboy);
					tommyboy.setNext(check);
					added=true;
				}
				trail=trail.getNext();
			}
			if(check.getNext()==null && !added)
				check.setNext(tommyboy);
		}
		else
			queueHead = tommyboy;
		
		objectCount++;
	}

	public E removeMin()
	{
		ListNode toReturn = queueHead;
		queueHead=queueHead.getNext();
		objectCount--;
		return (E)toReturn.getValue();
	}

	public E peek()
	{
		return (E)queueHead.getValue();
	}

	public boolean isEmpty()
	{
		return objectCount==0;
	}

	public int size()
	{
		return objectCount;
	}

	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer ("[ ");
		for (ListNode node = queueHead; node != null; node = node.getNext()) 
		{
			stringbuf.append(node.getValue()+" ");
		}
		stringbuf.append("]");
		return stringbuf.toString();
	}
}