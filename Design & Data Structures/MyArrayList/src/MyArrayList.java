/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {
    
    /* Internal Object counter */
    protected int objectCount;
    
    /* Internal Object array */
    protected E [] internalArray;
    
    /* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
    public MyArrayList() {
        this.internalArray = (E[])new Object[100];
    }
    
    /* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity){
        this.internalArray = (E[])new Object[initialCapacity];
    }
    
    /* Return the number of active slots in the array list */
    public int size() {
        return objectCount;
    }
    
    /* Are there zero objects in the array list? */
    public boolean isEmpty() {
        if(objectCount==0)
        	return true;
        else
        	return false;
    }
    
    /* Get the index-th object in the list. */
    public E get(int index) {
    	if (index>=0 && index < objectCount)
    		return(internalArray[index]);
    	else
    		throw new IndexOutOfBoundsException("That index is trespassing!");
    }
    
    /* Replace the object at index with obj.  returns object that was replaced. */
    public E set(int index, E obj) {
        if(index>= 0 && index < objectCount) {
        	E temp = internalArray[index];
        	internalArray[index] = obj;
        	return temp;
        }
        else
        	throw new IndexOutOfBoundsException("That index is trespassing!");
    }

	/* Returns true if this list contains an element equal to obj;
	 otherwise returns false. */
    public boolean contains(E obj) {
    	/* ---- YOUR CODE HERE ---- */
    	boolean store = false;
    	for(int i = 0; i < objectCount; i++) {
    		if(obj!=null&&internalArray[i]!=null) {
    		if(internalArray[i].equals(obj))
    			store = true;
    		}
    		else if (obj==null&&internalArray[i]==null)
    			return true;
    	}
    	return store;
    }
    
    /* Insert an object at index */
	@SuppressWarnings("unchecked")
    public void add(int index, E obj) {
        /* ---- YOUR CODE HERE ---- */
		if(index>=0 && index <= objectCount) {
			int count = 0;
			E[] newArr = (E[]) new Object[objectCount+1];
			for(int i = 0; i < objectCount; i++) {
				if(i==index)
					newArr[i]=obj;
			}
			
			objectCount++;
			
			for(int i = 0; i < objectCount; i++) {
				if(newArr[i]==null) {
					newArr[i] = internalArray[count];
					count++;
				}	
			}
			internalArray=newArr;
			
		}
		else
			throw new IndexOutOfBoundsException("That index is trespassing!");
	}

    /* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
    public boolean add(E obj) {
        /* ---- YOUR CODE HERE ---- */
		if(internalArray.length==objectCount)
		internalArray = increaseCapacity((int)(size()+ 0.25 * size() + 1));
		
		internalArray[size()] = obj;
		objectCount++;
		return true;
    }

    /* Remove the object at index and shift.  Returns removed object. */
    public E remove(int index) {
        /* ---- YOUR CODE HERE ---- */
    	if(index>= 0 && index < objectCount) {
    		E temp = internalArray[index];
    		for(int i = index+1; i < objectCount; i++) {
    			internalArray[i-1] = internalArray[i];
    		}
    		objectCount-=1;
    		return temp;
    	}
    	else
			throw new IndexOutOfBoundsException("That index is trespassing!");
    }
    
    /* Removes the first occurrence of the specified element from this list, 
     * if it is present. If the list does not contain the element, it is unchanged. 
     * More formally, removes the element with the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
     * Returns true if this list contained the specified element (or equivalently, 
     * if this list changed as a result of the call). */
    public boolean remove(E obj) {
        /* ---- YOUR CODE HERE ---- */
    	if(!contains(obj))
    		return false;
    	else {
    		int index = -1;
    		for(int i = 0; i < objectCount; i++) {
    			if(internalArray[i]==null && obj==null){
    				index = i;
    				i = objectCount;
    			}
    			if(internalArray[i]!=null && obj!=null) {
    			if(internalArray[i].equals(obj)) {
    				index = i;
    				i = objectCount;
    			}
    			}
    		}
    		remove(index);
    		return true;
    	}
    }
    
    /* For testing; your string should output as "{ X X X X ... }" where X X X X ... are the elements in the array.
     * If the array is empty, it should return "{ }".  If there is one element, "{ X }", etc.
     * Elements are separated by a space. */
    public String toString() {
        String toReturn = "{ ";
        for(int i = 0; i < objectCount; i++) {
        	toReturn+=internalArray[i] + " ";
        }
        toReturn += "}";
        return toReturn;
    }
    
    
    /*
     * Additional Helper Methods
     */
    
    /*
     * Create a new, larger internal array with length newCapacity
     * Copy the old internal array into the new array
     */
    private E[] increaseCapacity(int newCapacity) {
    	E[] newArr = (E[])new Object[newCapacity];
    	for(int i = 0; i < objectCount; i++) {
    		newArr[i] = internalArray[i];
    	}
    	return newArr;
    }
}