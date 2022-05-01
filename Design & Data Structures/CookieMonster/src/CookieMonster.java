import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* YOU ARE ALLOWED (AND EXPECTED) TO USE THE JAVA ARRAYDEQUE CLASS */

public class CookieMonster {

    private int [][] cookieGrid;
    private int numRows;
    private int numCols;
    private int mostCookies = -1;
    private int maxCallStackDepth = -1; //Used only for recursive technique

    public CookieMonster(int [][] cookieGrid) {
        this.cookieGrid = cookieGrid;
        this.numRows    = cookieGrid.length;
        this.numCols    = cookieGrid[0].length;
    }

    /* Return the calculated most cookies edible on the optimal path. */
    public int getMostCookies() {
        return mostCookies;
    }

    private boolean goodPoint(int row, int col) {
        return (row >= 0 && row < numRows && col >= 0 && col < numCols && cookieGrid[row][col] >= 0);
    }

	/* RECURSIVELY calculates the route which grants the most cookies, and returns the maximum depth the call stack reached during the operation. */
	public int maxCallStackDepth() {
		this.mostCookies = recursiveOptimalPath(0, 0, 1);
		return maxCallStackDepth;
	}	

	/* Helper function for the above, which returns the maximum number of cookies edible starting at coordinate (row, col). */
	/* From any given position, always check right before checking down */
	/* Also, updates the maxCallStackDepth variable, to find out how deep the recursion call stack got during the operation. 
	 * I've implemented this part already (you should add 1 to the depth when it calls itself). */ 

	private int recursiveOptimalPath(int row, int col, int depth) {
		if (depth > this.maxCallStackDepth)
			this.maxCallStackDepth = depth;
		
		int right = -1;
		int down = -1;
		
		int total = 0; 
		total = cookieGrid[row][col];
		
		if(goodPoint(row, col+1))
			right = recursiveOptimalPath(row, col+1, depth+1);
		if(goodPoint(row+1, col))
			down = recursiveOptimalPath(row+1, col, depth+1);
		if(right>down)
			total+=right;
		else if(down > 0)
			total+=down;
		
		return total;
	}

	/* Calculate the route which grants the most cookies, and return the maximum queue size during the operation. */
    /* From any given position, always check right before checking down */
    /* Set this.mostCookies before returning */
	public int maxQueueSize() {
		ArrayDeque<PathMarker> queue = new ArrayDeque<PathMarker>();
		int maxQueueSize = 0;
		int mostCookiesSoFar = -1;
		queue.add(new PathMarker(0, 0, cookieGrid[0][0]));
		
		if(queue.peek().total>mostCookiesSoFar)
			mostCookiesSoFar=queue.peek().total;
		while(!queue.isEmpty()) {
			PathMarker check = queue.poll();
			if(check.col+1 < cookieGrid[0].length && cookieGrid[check.row] [check.col+1] != -1) {
				queue.add(new PathMarker(check.row, check.col+1, check.total + cookieGrid[check.row] [check.col+1]));
				if(check.total + cookieGrid[check.row] [check.col+1]>mostCookiesSoFar)
					mostCookiesSoFar=check.total + cookieGrid[check.row] [check.col+1];
			}
			if(check.row+1 < cookieGrid.length && cookieGrid[check.row+1] [check.col] != -1) {
				queue.add(new PathMarker(check.row+1, check.col, check.total + cookieGrid[check.row+1] [check.col]));
				if(check.total + cookieGrid[check.row+1] [check.col]>mostCookiesSoFar)
					mostCookiesSoFar=check.total + cookieGrid[check.row+1] [check.col];
			}
			if(maxQueueSize < queue.size())
				maxQueueSize=queue.size();
			
		}

		this.mostCookies=mostCookiesSoFar;
		return maxQueueSize;

    }

    /* Calculate the route which grants the most cookies, and return the maximum stack size during the operation. */
    /* From any given position, always check right before checking down */
    /* Set this.mostCookies before returning */
    public int maxStackSize() {
    	ArrayDeque<PathMarker> stack = new ArrayDeque<PathMarker>();
    	int maxStackSize = 0;
    	int mostCookiesSoFar = -1;
    	stack.push(new PathMarker(0, 0, cookieGrid[0][0]));

    	
    	if(stack.peek().total>mostCookiesSoFar)
			mostCookiesSoFar=stack.peek().total;
		while(!stack.isEmpty()) {
			PathMarker check = stack.pop();
			
			if(check.col+1 < cookieGrid[0].length && cookieGrid[check.row] [check.col+1] != -1) {
				stack.push(new PathMarker(check.row, check.col+1, check.total + cookieGrid[check.row] [check.col+1]));
				
				if(stack.peek().total>mostCookiesSoFar)
					mostCookiesSoFar=stack.peek().total;
			}
			
			if(check.row+1 < cookieGrid.length && cookieGrid[check.row+1] [check.col] != -1) {
				stack.push(new PathMarker(check.row+1, check.col, check.total + cookieGrid[check.row+1] [check.col]));
				
				if(stack.peek().total>mostCookiesSoFar)
					mostCookiesSoFar=stack.peek().total;
			}
			
			if(maxStackSize < stack.size())
				maxStackSize=stack.size();
			
		}

		this.mostCookies=mostCookiesSoFar;
		return maxStackSize;
    }

    /* Calculate the route which grants the most cookies, and return the maximum priority queue size during the operation. */
    /* From any given position, always check right before checking down */
    /* Set this.mostCookies before returning */
   //public int maxPriorityQueueSize() {
    //    HeapPQ<PathMarker> priorityQueue = new HeapPQ<PathMarker>();
    //    int maxPriorityQueueSize = 0;
     //   int mostCookiesSoFar = -1;
     //   priorityQueue.add(new PathMarker(0, 0, cookieGrid[0][0]));

        /* -- YOU IMPLEMENT THIS -- */
   // }


}
