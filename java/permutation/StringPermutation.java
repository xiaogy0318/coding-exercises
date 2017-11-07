import java.util.*;

public class StringPermutation {
	
	public static Vector findStringPermutations(String myString) {
		System.out.println("Entering function with input: " + myString);
		Vector result = new Vector();
		
		if (0 == myString.length()) {
			
		}
		
		else if (1 == myString.length()) {
			
			result.add(myString);
		}
		else {
		
			for (int i = 0; i < myString.length(); i++) {
				char[] myCharArray = new char[1];
				char myChar = myString.charAt(i);
				myCharArray[0] = myChar;
				
				// Form a new String by taking out the specified char from the string
				String strippedString = stripString(myString, i);
				
				Vector subStringResult;
				if (0 == strippedString.length()) {
					result.add(new String(myCharArray));
				}
				else {
					subStringResult = findStringPermutations(strippedString);
					
					for (int j = 0; j < subStringResult.size(); j++) {
						result.add(new String(myCharArray) + subStringResult.elementAt(j));
					}
				}
			}
		}
		System.out.println("Leaving function with input: " + myString + ", reult: " + result);

		return result;

	}
	
	public static String stripString(String myString, int index) {
		if (1 == myString.length()) {
			return "";
		}
		
		if (0 == index) {
			return myString.substring(1);
		}
		else if (myString.length() - 1 == index) {
			return myString.substring(0, index);
		}
		else {
			return myString.substring(0, index) + myString.substring(index + 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(findStringPermutations("abcd"));
		//System.out.println(stripString("abc", 1));
	}
}