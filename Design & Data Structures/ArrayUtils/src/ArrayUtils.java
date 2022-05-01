public class ArrayUtils {
    
    /* countOdds
     * This method should return the number of odd integers in the array.
     * Odd integers are not divisible by 2.
     * 0 is an even integer.
     */
    public static int countOdds(int[] nums) {
        int sum = 0;
        for(int num : nums) {
        	if(num % 2 != 0)
        		sum++;
        	
        }
        return sum;
    }
    
    /* onDiagonal
     * This method takes a 2D array of integers, and a single integer parameter.
     * It returns true if and only if the value of the parameter lies on a diagonal of the
     * 2D array.
     * 
     * Diagonals are illustrated here (X is on diagonal, . is not):
     * 
     * X.X  X..X  X...X
     * .X.  .XX.  .X.X.  etc.
     * X.X  .XX.  ..X..
     *      X..X  .X.X.
     *            X...X
     *            
     * 2D arrays that are not square do not have diagonals, and should always return false.
     */
    public static boolean onDiagonal(int[][] matrix, int test) {
        if(matrix.length != matrix[0].length)
        	return false;
        
    	for(int i = 0; i < matrix.length; i++) {
    		if(test==matrix[i][i])
    			return true;
    		if(test==matrix[matrix.length-1-i][i])
    			return true;
    	}
    	
    	return false;
    	
  
    }
    
    /* addElements
     * This method takes two 1D integer arrays: list and increment.
     * The list array is mutated such that the ith element of list will be incremented by the ith
     * element of increment.
     * 
     * e.g.             list -> (0, 0, 1, 1,  2,  2)
     *             increment -> (4, 5, 6, 7,  8,  9)
     * after returning, list -> (4, 5, 7, 8, 10, 11)
     * 
     * If increment is not as long as list, treat unspecified values as 0.
     * 
     * e.g.             list -> (0, 0, 1, 1, 2, 2)
     *             increment -> (4, 5, 6, 7)
     * after returning, list -> (4, 5, 7, 8, 2, 2)
     * 
     * If increment has more elements than list, ignore the extra elements.
     */
    public static void addElements(int[] list, int[] increment) {
        int c = 0;
        while(c<list.length && c < increment.length) {
        	list[c]+=increment[c];
        	c++;
        }
    }
    
    /* embiggen
     * Merges two 1D integer arrays into a single 2D integer array.
     * The [i][j] element of the resulting array is whichever value is larger: array1[i] or array2[j].
     */
    public static int[][] embiggen(int[] array1, int[] array2) {
        int[][] rect = new int[array1.length][array2.length];
        for(int i = 0; i < array1.length; i++) {
        	for(int j = 0; j < array2.length; j++) {
        		if(array1[i]>array2[j])
        			rect[i][j] = array1[i];
        		else
        			rect[i][j] = array2[j];
        	}
        }
        return rect;
    }
}