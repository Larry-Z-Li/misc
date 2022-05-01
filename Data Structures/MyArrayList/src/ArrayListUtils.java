import java.util.ArrayList;

public class ArrayListUtils {

	
	//Or from back to front is a touch better
	public static void moveToBack3(ArrayList list, Object obj)
	{
		int count = 0;
		ArrayList temp = new ArrayList();
		for(int i = 0; i < list.size(); i++) {
			if(!list.get(i).equals(obj)) {
				temp.add(list.get(i));
				count++;
			}
		}
		
		while(temp.size() < list.size()) {
			temp.add(obj);
		}
		
		for(int i = 0; i < list.size(); i++) {
			list.set(i, temp.get(i));
			/*
			System.out.println("Me, the esteemed Index " + i + ", was just assigned a value.");
			while((int) (Math.random()*1000000 + 1) != 1)
			{
			 System.out.println ("HI");
			}
			*/
		}
	}
	
	public static void moveToBack2(ArrayList list, Object obj) {
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(obj)) {
			list.add(list.remove(i));
			i--;
			count++;
			}
			if(i >= list.size()-count)
				i = list.size();
		}
	}
	
	public static void moveToBack(ArrayList list, Object obj) {
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			if(!list.get(i).equals(obj)) {
				list.set(count, list.get(i));
				count++;
			}
		}
		
		for(int i = count; i < list.size(); i++) {
			list.set(i, obj);
		}
	}
	
	
	
	public static void main(String[] args)
	{
	ArrayList<Integer> ints = new ArrayList<Integer>();
	//Set max to 10000000 for an efficiency check, or 100 for an accuracy check
	int max = 10000000;
	for (int i = 0; i < max; i++)
	{
	if (i % 5 == 0 || i % 17 == 0)
	ints.add(new Integer(1));
	else
	ints.add(new Integer(2));
	}
	long startTime = System.currentTimeMillis();
	ArrayListUtils.moveToBack(ints, new Integer(1));
	long totalTime = System.currentTimeMillis() - startTime;
	System.out.println("Total milliseconds for moveToBack is " + totalTime);
	boolean mistake = false;
	for (int i = 0; !mistake && i < max*6/10; i++)
	{
	if (ints.get(i).equals(new Integer(1)))
	mistake = true;
	}
	if (!mistake)
	System.out.println("Probably correct!");
	else
	System.out.println("Incorrect!");
	}

}
