import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Stack;

public class stackQ {

	public static void main(String[] args) {
		String originString = "Somthing";
		stackMethod(originString);
		System.out.println();

		System.out.println();
		String Parentheses = "}";
		calculateParenthesesWithStack(Parentheses);
		System.out.println();

		String splitString = "Reverse me if you can";
		reverseWordInSentanceStack(splitString);
		System.out.println();
		reverseWordInSentance(splitString);

		System.out.println();
		System.out.println();
		ArrayList<String> stringArr = new ArrayList<String>();
		stringArr = splitMethod(splitString);
		System.out.println(stringArr);
	}

	/**
	 * This method will take the strings given and reverse it then display it using
	 * slack for example: input: "Somthing" then the output will be: gnihtmoS
	 * 
	 * @param origString
	 */
	public static void stackMethod(String origString) {
		Stack<Character> addElements = new Stack<Character>();
		for (int index = 0; index < origString.length(); index++) {

			addElements.push(origString.charAt(index));
		}
		while (!addElements.empty()) {
			System.out.print(addElements.pop());
		}
	}

	/**
	 * This method will take the strings given and calculate the parentheses using
	 * slack if the close parentheses match open parentheses it will display valid
	 * else not valid for example: input: "{}" then the output will be: valid for
	 * example: input: "}{" then the output will be: not valid
	 * 
	 * @param origString
	 */
	public static void calculateParenthesesWithStack(String origString) {
		Stack<Character> addElements = new Stack<Character>();
		int countOpenParentheses = 0;
		int countCloseParentheses = 0;
		for (int index = 0; index < origString.length(); index++) {
			char element = origString.charAt(index);
			// calculate the number of open and close parentheses
			if (element == '{') {
				countOpenParentheses++;
			} else if (element == '}') {
				countCloseParentheses++;
			}
			// add the open parentheses inside stack
			if (element == '{') {
				addElements.push(element);
			}
			// delete open parentheses with close parentheses
			if (element == '}') {
				if (!addElements.empty() && countOpenParentheses != 0) {
					addElements.pop();
				}
			}
		}
		// display the results
		if (addElements.empty() && countOpenParentheses != 0 && countOpenParentheses == countCloseParentheses) {
			System.out.println("valid");

		} else {
			System.out.println("Not valid");
		}
	}

	/**
	 * This method will take the strings given and reverse it then display it using
	 * slack for example: input: "Reverse me if you can" then the output will be:
	 * "can you if me Reverse"
	 * 
	 * @param origString
	 */
	public static void reverseWordInSentanceStack(String origString) {
		Stack<String> collectwordStrings = new Stack<String>();
		String[] arrOfStr = origString.split(" ");

		for (String a : arrOfStr) {
			collectwordStrings.push(a);
		}
		while (!collectwordStrings.empty()) {
			System.out.print(collectwordStrings.pop() + " ");
		}
	}
	/**
	 * This method will take the strings given and reverse it then display it using
	 * iteration for example: input: "Reverse me if you can" then the output will be:
	 * "can you if me Reverse"
	 * 
	 * @param origString
	 */
	public static void reverseWordInSentance(String origString) {
		ArrayList<String> collectwordStrings = new ArrayList<String>();
		String[] arrOfStr = origString.split(" ");

		for (int index = arrOfStr.length - 1; index >= 0; index--) {
			collectwordStrings.add(arrOfStr[index]);
		}
		for (String i : collectwordStrings) {
			System.out.print(i + " ");
		}

	}

	/**
	 * Implement .split method. split should take a character as input and returns
	 * an array of strings.
	 * 
	 * INPUT: "Reverse me if you can" OUTPUT: ["Reverse", "me", "if", "you", "can"]
	 * @param origString
	 * @return stringArr
	 */
	public static ArrayList<String> splitMethod(String origString) {
		//create arraList to collect the characters of the origString
		ArrayList<Character> charArr = new ArrayList<Character>();
		for (int index = 0; index < origString.length(); index++) {
			charArr.add(origString.charAt(index));
		}
		
		//create arraList to add the characters in a string add add it inside the arraList
		ArrayList<String> stringArr = new ArrayList<String>();
		String collectChar = "";
		for (int index = 0; index < charArr.size(); index++) {
			collectChar = collectChar + Character.toString(charArr.get(index));
			if (charArr.get(index) == ' ') {
				stringArr.add(collectChar);
				collectChar = "";
			} else if (index == charArr.size() - 1) {
				stringArr.add(collectChar);
			}
		}
		return stringArr;
	}

}
