package main;

public class OfflineExercises {

	public static void main(String[] args) {
		OfflineExercises offlineExercises = new OfflineExercises();
		int something = offlineExercises.largest("55 45 66");
	}

	// Inputs a String and Splits it using substrings into an array of characters.
	// Rather than just using .split("")
	public String[] toIndividualCharacterStringsArray(String input) {

		String[] characterStringsArray = new String[input.length()];
		for (int i = 0; i < input.length(); i++) {
			characterStringsArray[i] = input.substring(i, i + 1);
			// System.out.println(characterStringsArray[i]);
		}

		return characterStringsArray;
	}

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {

		String tripledString = "";
		String[] splitStringArray = toIndividualCharacterStringsArray(input);
		for (String letter : splitStringArray) {
			tripledString = tripledString + letter + letter + letter;
		}

		return tripledString;
	}

	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {

		boolean foundOnce = false;
		boolean foundTwice = false;
		int startPoint = 0;
		int endPoint = 0;

		String caseLessInput = input.toLowerCase();

		for (int i = 0; i < caseLessInput.length() - 3; i++) { // Don't check the last 3 letters or we go out of bounds
																// and they won't be bert anyway
			String subString = caseLessInput.substring(i, i + 4);

			if (subString.equals("bert")) {
				if (foundOnce == false) {
					foundOnce = true;
					startPoint = i + 4; // Set the Start point to the letter after bert.
				} else {
					foundTwice = true;
					endPoint = i; // Set the finish to the b in this bert.
				}
			}
		} // end for

		if (foundTwice == true) {
			String[] betweenBertArray = new String[(endPoint - startPoint)];
			int fillCount = 0;

			// Select the letters between start and end points.
			for (int i = startPoint; i < endPoint; i++) {
				betweenBertArray[fillCount] = input.substring(i, i + 1); // pops them in this array
				fillCount++;
			}

			// reverse the array
			String[] reverseBetweenBertArray = new String[betweenBertArray.length];
			int counter = 0;
			for (int i = betweenBertArray.length - 1; i >= 0; i--) {
				reverseBetweenBertArray[counter] = betweenBertArray[i];
				counter++;
			}

			String reversedString = "";

			for (String letter : reverseBetweenBertArray) {
				reversedString = reversedString + letter;
			}

			return reversedString;
		}
		// Else
		return "";

	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {

		int smallNumber = 0;
		int mediumNumber = 0;
		int bigNumber = 0;
		int difference;

		// This takes the inputs and stores them in a certain variable depending on
		// their size.
		// --------------------------------------------------------------
		if (a > b && a > c) { // if a is the biggest set it as such
			bigNumber = a;
			if (b > c) {
				mediumNumber = b;
				smallNumber = c;
			} else {
				mediumNumber = c;
				smallNumber = b;
			}

		} else if (a > b && a < c || a > c && a < b) { // if a is the medium number
			mediumNumber = a;
			if (b > a) {
				bigNumber = b;
				smallNumber = c;
			} else {
				bigNumber = c;
				smallNumber = b;
			}
		} else if (a < b && a < c) { // if a is the smallest
			smallNumber = a;
			if (b > c) {
				bigNumber = b;
				mediumNumber = c;
			} else {
				bigNumber = c;
				mediumNumber = b;
			}

		}
		// ---------------------------------------------------------------

		difference = bigNumber - mediumNumber;

		if (difference == (mediumNumber - smallNumber)) {
			return true;
		}
		// Else

		return false;
	}

	// Given a string and an int n, return a string that removes n letters from the
	// 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input
	// is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {

		String[] stringArray = toIndividualCharacterStringsArray(input);
		int lettersRemaining = stringArray.length - a;

		String firstStringHalf = "";
		String secondStringHalf = "";

		firstStringHalf = (input.substring(0, 0 + (lettersRemaining / 2)));
		secondStringHalf = (input.substring((lettersRemaining / 2) + a));
		// take letters remaining/2 from start then take takenletters+letters to acquire
		// the end

		String newString = firstStringHalf + secondStringHalf;
		return newString;
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("jh") → false
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {

		String caseLessInput = input.toLowerCase();
		String[] stringArray = toIndividualCharacterStringsArray(caseLessInput);
		if (stringArray.length < 3) {
			return false;
		}
		if ("dev".equals(caseLessInput.substring(stringArray.length - 3))) {

			return true;
		}

		return false;
	}

	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {

		String[] stringArray = toIndividualCharacterStringsArray(input);
		String currentLetter = null;
		int highestCount = 0;
		int count = 0;

		for (String letter : stringArray) {
			if (letter.equals(currentLetter)) {
				count++;
			} else {
				if (count > highestCount) {
					highestCount = count;
				}
				currentLetter = letter;
				count = 1;
			}
		}

		return highestCount;

	}

	// given a string - return the number of times "am" appears in the String
	// ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by
	// other letters
	//
	// amISearch("Am I in Amsterdam") → 1
	// amISearch("I am in Amsterdam am I?") → 2
	// amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {

		String caseLessInput = arg1.toLowerCase();
		String[] stringArray = toIndividualCharacterStringsArray(caseLessInput);

		String newInput = " ";
		for (String letter : stringArray) {
			newInput = newInput + letter;
		}
		newInput = newInput + " ";

		int count = 0;

		for (int i = 0; i < newInput.length() - 4; i++) {
			if (" am ".equals(newInput.substring(i, i + 4))) {
				count++;
			}

		}

		return count;

	}

	// given a number
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3 and 5return "fizzbuzz"
	//
	// fizzBuzz(3) → "fizz"
	// fizzBuzz(10) → "buzz"
	// fizzBuzz(15) → "fizzbuzz"

	public String fizzBuzz(int arg1) {

		String returnString = "";
		int fizzResult = Math.floorMod(arg1, 3);
		
		if (fizzResult == 0) {
			returnString = returnString + "fizz";	
		}
		
		int buzzResult = Math.floorMod(arg1, 5);
		
		if (buzzResult == 0) {
			returnString = returnString + "buzz";	
		}

		return returnString;

	}

	// Given a string split the string into the individual numbers present
	// then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	// largest("55 72 86") → 14
	// largest("15 72 80 164") → 11
	// largest("555 72 86 45 10") → 15

	public int largest(String arg1) {
		
		//Split by spaces into arrays
		// Split by numbers to do math
		
		int highestValue = 0;
		
		
		String[] stringSpacesArray = arg1.split(" "); // I've tried to avoid doing .split till now, but I want to solve this then try and not use it?
		
		
		for (String numbers : stringSpacesArray) {
			int sum = 0;
			System.out.println(numbers);
			String[] individualNumbers = toIndividualCharacterStringsArray(numbers);
			for (int i = 0; i < individualNumbers.length; i++) {
				sum = sum + Integer.parseInt(individualNumbers[i]);
				 
			}
			
			if (sum > highestValue) {
				System.out.println("hIGHER!");
				highestValue = sum;
			}
		}
		
		
		
		return highestValue;

	}

}
