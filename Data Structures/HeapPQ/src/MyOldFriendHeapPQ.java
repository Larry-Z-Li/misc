
public class MyOldFriendHeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {
	private E[] heap;
	private int objectCount;
	
	public MyOldFriendHeapPQ()
    {
        this.heap = (E[])new Comparable[3];
        this.objectCount = 0;
    }

	//Adds obj to the Priority Queue
	public void add(E obj)
	{
		if(objectCount==heap.length-1 || objectCount==0) {
			increaseCapacity();
		}
		if(!isEmpty()) {
			heap[objectCount+1] = obj;
			bubbleUp(objectCount+1);
		}
		else
			heap[1]=obj;
		
		objectCount++;
	}
	
	//Removes and returns the MINIMUM element from the Priority Queue
	public E removeMin()
	{
		if(objectCount==1) {
			E temp = heap[1];
			heap[1]=null;
			objectCount--;
			return temp;
		}
		if(objectCount==2 && heap[1].compareTo(heap[2]) > 0) {
			E temp = heap[2];
			heap[2] = null;
			objectCount--;
			return temp;
		}
		else if(objectCount==2) {
			swap(1,2);
			E temp = heap[2];
			heap[2] = null;
			objectCount--;
			return temp;
		}
		swap(1, objectCount);
		E tom = heap[objectCount];
		heap[objectCount]=null;
		objectCount--;
		bubbleDown(1);
		return tom;
		
	}
	
	//Returns the MINIMUM element from the Priority Queue without removing it
	public E peek()
	{
		return heap[1];
	}
	
	// Returns true if the priority queue is empty
	public boolean isEmpty()
	{
		return (objectCount==0);
	}
	
	//Returns the number of elements in the priority queue
	public int size()
	{
		return objectCount;
	}
	
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++)
		{
			stringbuf.append(heap[i+1]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for(int rowLength = 1, j = 0; j < objectCount; rowLength *= 2)
		{
			for (int i = 0; i < rowLength && j < objectCount; i++, j++)
			{
				stringbuf.append(heap[j+1] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount)
			{
				for (int i = 0; i < Math.min(objectCount - j, rowLength*2); i++)
				{
					if (i%2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}
	
	//Doubles the size of the heap array
	private void increaseCapacity()
	{
		E[] temp = (E[]) new Comparable[2*heap.length+2];
		for(int i = 0; i <= objectCount; i++) {
			temp[i]=heap[i];
		}
		heap = temp;
	}

	//Returns the index of the "parent" of index i
	private int parent(int i)
	{
		return (i/2);
	}
	//Returns the *smaller child* of index i
	private int smallerChild(int i)
	{
		E left = heap[2*i];
		E right = heap[2*i+1];
		if(right==null)
			return 2*i;
		if(left.compareTo(right) < 0) {
			return 2*i;
		}
		else if(left.compareTo(right) > 0) {
			return 2*i+1;
		}
		else
			return 2*i;
	}
	//Swaps the contents of indices i and j
	private void swap(int i, int j)
	{
		E temp = heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i)
	{
		while(heap[i/2].compareTo(heap[i]) > 0) {
			swap(i/2, i);
			if(i/2 > 1)
				i = i/2;
			else
				return;
		}
	}
	
	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i)
	{
		int tommyboy = -1;
		
		while(heap[smallerChild(i)].compareTo(heap[i]) < 0) {
			tommyboy = smallerChild(i);
			swap(smallerChild(i), i);
			if(tommyboy*2<objectCount)
				i = tommyboy;
			else
				return;
		}
	}
}
