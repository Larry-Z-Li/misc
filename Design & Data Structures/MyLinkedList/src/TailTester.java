
public class TailTester {

	public static void main(String[] args) {

		SinglyLinkedList a = new SinglyLinkedList();
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			a.add(i);
		}
		a.remove(a.size()-1);
		a.remove(a.size()-1);
		for (int i = 0; i < 100000; i++) {
			a.add(i);
		}

		System.out.println("Should be 2: " + a.get(100000));
		long endTime = System.currentTimeMillis();
		System.out.println("YOUR SCORE: " + (120 - (endTime - startTime)));


	}

}
