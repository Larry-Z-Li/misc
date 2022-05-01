import java.util.Collections;

public class MySortedArrayList<E> {
	
protected int objectCount;
    
    /* Internal Object array */
    protected E [] internalArray;
    
    /* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
    public MySortedArrayList() {
        this.internalArray = (E[])new Object[100];
    }
    
    /* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
    public MySortedArrayList(int initialCapacity){
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
	
	public boolean contains(E obj) {
		if(Collections.binarySearch(internalArray,  obj))
			return true;
		else
			return false;
	}
	
	public boolean add(E obj) {
		if(internalArray.length==objectCount)
			internalArray = increaseCapacity((int)(size()+ 0.25 * size() + 1));
			
			internalArray[size()] = obj;
			objectCount++;
			
			return true;
	}
	
	public E remove(int index) {
		
	}
	
	public boolean remove(E obj) {
		
	}
}
