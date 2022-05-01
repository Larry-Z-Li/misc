public class Palindrome {
    
    /* Determine if the String argument is a palindrome.
     * Only consider standard alphabet characters (a-z, A-Z).
     * Ignore case.
     * e.g. The string "1 HELLO oll- 2 - e h" *is* a palindrome.
     * 
     * An empty or null string is *not* a palindrome.
     */
    public boolean isPalindrome(String name) {
    	if(name.length()==0)
    		return false;
    	if(name.length()==1)
    		return true;
    	if(name.length()==2 && name.charAt(0)==name.charAt(1))
    		return true;
    	else if(name.length()==2)
    		return false;
    	
    	String letters = "";
    	for(int i = 0; i < name.length(); i++) {
    		if(Character.isLetter(name.charAt(i))) {
    			letters+=name.substring(i, i+1);
    		}
    	}
    	String half1 = letters.substring(0, letters.length()/2);
    	
    	String half2 = "";
    	for(int i = letters.length()-1; i > half1.length(); i--) {
    		half2+=letters.substring(i, i+1);
    	}
    	
    	if(half1.equals(half2.substring(0, half1.length())))
    		return true;
    	else
    		return false;
    	}
    
    
    
}