import java.util.Random;

public class HashNames {

	public static void main(String[] args) {
		int hashTableSize = 45;
		String[] students = {
				"Chase Van Amburg",
				"Diego Ahmad",
				"Tammer Bagdasarian",
				"Jaden Blaser",
				"Amanda Chan",
				"Jaz Choi",
				"Whitney Elson",
				"Guy Hartstein",
				"Tyra Hirooka",
				"Coco Kaleel",
				"Jenna Kronenberg",
				"Darren Long",
				"Berry Nakash",
				"Clay Skaggs",
				"Lexi So",
				"Ashtin Wang",
				"Sabina Yampolsky",
				"Dean Barkin",
				"Stephanie Cho",
				"Pablo Greenlee",
				"Ethan Hodess",
				"Jack Hoppus",
				"Avery Keare",
				"Sofia Kim",
				"Lawrence Li",
				"Will Liu",
				"Kevin Lu",
				"Monica Martell",
				"Bryant Reese",
				"Dean Reiter",
				"Alexander Saffari",
				"Will Seymour",
				"Mitchell Thompson",
				"JP Wong",
				"Jason Santillan",
				"Hana Takei",
				"Warren Wang",
				"Chance Washburn",
				"Nick Witham",
				"Paige Yoo",
				"Miles Povich",
				"Mitch Burdorf",
				"Aileen Cano",
				"Jacob Cohn",
				"Marie Eric",
				"Dylan Faulcon",
				"Timothy Kihiczak",
				"Nicole Kim",
				"Xander Klein",
				"Keller Maloney",
				"Alec Mendelsohn",
				"Jonty Nobbs",
				"Paul Rodriguez",
				"Tiber Seireeni",
				"Nick Settelmayer",
				"Pavan Tauh"
		};
		int collisions = 0;
		int[] chainLengths = new int[hashTableSize];
		int maxChainLength = 0;
		int emptyBuckets = hashTableSize;
		for (String student : students)
		{
			int index = (myHash(student) & 0x7FFFFFFF) % hashTableSize;
			System.out.println(student + " " + (student.hashCode()& 0x7FFFFFFF));
			if (chainLengths[index] != 0)
			{
				collisions++;
				System.out.println(student);
			}
			else
				emptyBuckets--;

			chainLengths[index]++;
			if (chainLengths[index] > maxChainLength)
				maxChainLength = chainLengths[index];

		}

		float usedProportion = ((float) (hashTableSize - emptyBuckets)) / ((float) hashTableSize);
		System.out.println("Total collisions: " + collisions);
		System.out.println("Proportion of collisions: " +((float) collisions) / ((float) students.length));
		System.out.println("Max chain length: " + maxChainLength);
		System.out.println("Proportion of used buckets: " + usedProportion);

	}

	private static int myHash(String s)
	{
		//Make up your own hash function!
		int yummy = 1;
		for(int i = 0; i < s.length(); i++) {
		yummy*=7*s.charAt(i)+1;
		}
		
		
		return yummy;
	}

}
