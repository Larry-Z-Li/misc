import java.util.ArrayList;

public class HasLoopTester {
	public static void main(String [] args) {
		ListNode badList = new ListNode("1", new ListNode("2", new ListNode("3")));
        badList.getNext().getNext().setNext(badList.getNext());
        ListNode goodList = new ListNode("1", new ListNode("2", new ListNode("3")));
        
        System.out.println("Should be true: " + hasLoop(badList));
        System.out.println("Should be false: " + hasLoop(goodList));
	}
	
	public static boolean hasLoop1(ListNode head) {
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		ListNode check = head;
		while(check!=null) {
			list.add(check);
			check=check.getNext();
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i)==check)
					return true;
			}
		}
		return false;
		
	}
	
	public static boolean hasLoop(ListNode head) {
		ListNode check = head;
		int count = 0;
		while(check!=null) {
			count++;
			check=check.getNext();
			ListNode quick = head;
			for(int i = 0; i < count; i++) {
				if(quick==check)
					return true;
				quick=quick.getNext();
			}
		}
		return false;
	}
}
