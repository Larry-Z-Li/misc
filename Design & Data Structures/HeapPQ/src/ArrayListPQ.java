
//PQ = Priority Queue

import java.util.ArrayList;

public class ArrayListPQ<E extends Comparable<E>> implements MyPriorityQueue<E>{

	private ArrayList<E> queue;
	
	public ArrayListPQ()
	{
		queue = new ArrayList<E>();
	}
	
	public void add(E obj)
	{
		queue.add(obj);
	}
	
	public E removeMin()
	{
		E temp = queue.get(0);
		for(int i = 1; i < queue.size(); i++) {
			if(queue.get(i).compareTo(temp)<0)
				temp = queue.get(i);
		}
		queue.remove(temp);
		return temp;
	}
	
	public E peek()
	{
		E temp = queue.get(0);
		for(int i = 1; i < queue.size(); i++) {
			if(queue.get(i).compareTo(temp)<0)
				temp = queue.get(i);
		}
		return temp;
	}
	
	public boolean isEmpty()
	{
		if(queue.size()>0)
			return false;
		else
			return true;
	}
	
	public int size()
	{
		return queue.size();
	}
	
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer ("[ ");	
		for (int i = 0; i < queue.size(); i++)
		{
			stringbuf.append(queue.get(i)+" ");
		}
		stringbuf.append("]");
		return stringbuf.toString();
	}

}
