
public class PalindromeTester {

	public static void main(String[] args) {
		Palindrome pal = new Palindrome();
		System.out.println(pal.isPalindrome("a"));
		System.out.println(pal.isPalindrome("aa"));
		System.out.println(pal.isPalindrome("ab"));
		System.out.println(pal.isPalindrome("aba"));;
		System.out.println(pal.isPalindrome("abc"));;
		System.out.println(pal.isPalindrome("racecar"));
		System.out.println(pal.isPalindrome("raccar"));

	}

}
