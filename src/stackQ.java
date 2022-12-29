import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stackQ {

	public static void main(String[] args) {
		// String originString = "Somthing";
		// stackMethod(originString);
		// System.out.println();

		System.out.println();
		String input = "}";
		String input1 = "{ int x= (int)(0+1); int[] arr=new arr[10];;;}}";
		String input2 = "[{()}]";
		String input3 = "]{()}[";
		String input4 = "([](";
		String input5 = "(arr[10})";
		String input6 = "[arr(10)[";
		String input7 = "([arr{(10)}])";
		calculateParenthesesWithStack(input7);
		System.out.println();

		String splitString = "NoOfSeats";
		//reverseWordInSentance(splitString);
		System.out.println();
		String splitString2 = "Reverse me if you can";
		//reverseSentance(splitString2);
		splitWithout(splitString2);

		// String splitString = "Reverse me if you can";
		// reverseWordInSentanceStack(splitString);
		// System.out.println();
		// reverseWordInSentance(splitString);
		//
		// System.out.println();
		// System.out.println();
		// ArrayList<String> stringArr = new ArrayList<String>();
		// char limit = ' ';
		// stringArr = splitMethod(splitString, limit);
		// System.out.println(stringArr);
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
		Stack<Character> addParentheses = new Stack<Character>();
		Stack<Character> addSquareBrackets = new Stack<Character>();
		Stack<Character> addBraces = new Stack<Character>();
		int countOpenParentheses = 0;
		int countCloseParentheses = 0;
		int countOpenSquareBrackets = 0;
		int countCloseSquareBrackets = 0;
		int countOpenBraces = 0;
		int countCloseBraces = 0;
		for (int index = 0; index < origString.length(); index++) {
			char element = origString.charAt(index);
			// calculate the number of open and close parentheses
			if (element == '{') {
				countOpenParentheses++;
			} else if (element == '}') {
				countCloseParentheses++;
			}
			// calculate the number of open and close SquareBrackets
			if (element == '[') {
				countOpenSquareBrackets++;
			} else if (element == ']') {
				countCloseSquareBrackets++;
			}
			// calculate the number of open and close Braces
			if (element == '(') {
				countOpenBraces++;
			} else if (element == ')') {
				countCloseBraces++;
			}

			// add the open parentheses inside stack
			if (element == '{') {
				addParentheses.push(element);
			}
			// add the open SquareBrackets inside stack
			if (element == '[') {
				addSquareBrackets.push(element);
			}
			// add the open Braces inside stack
			if (element == '(') {
				addBraces.push(element);
			}
			// delete open parentheses with close parentheses
			if (element == '}') {
				if (!addParentheses.empty() && countOpenParentheses != 0) {
					addParentheses.pop();
				}
			}
			// delete open SquareBrackets with close parentheses
			if (element == ']') {
				if (!addSquareBrackets.empty() && countOpenSquareBrackets != 0) {
					addSquareBrackets.pop();
				}
			}
			// delete open SquareBrackets with close parentheses
			if (element == ')') {
				if (!addBraces.empty() && countOpenBraces != 0) {
					addBraces.pop();
				}
			}
		}
		// display the results
		if (addParentheses.empty() && addSquareBrackets.empty() && addBraces.empty() && countOpenParentheses != 0
				&& countOpenParentheses == countCloseParentheses && countOpenSquareBrackets != 0
				&& countOpenSquareBrackets == countCloseSquareBrackets && countOpenBraces != 0
				&& countOpenBraces == countCloseBraces) {
			System.out.println("true (Meaning valid)");

		} else {
			System.out.println("false (Meaning Invalid)");
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
	 * iteration for example: input: "Reverse me if you can" then the output will
	 * be: "can you if me Reverse"
	 * 
	 * @param origString
	 */
	public static void reverseWordInSentance(String origString) {
		ArrayList<String> collectwordStrings = new ArrayList<String>();
		String[] arrOfStr = origString.split("(?=\\p{Lu})");
		//String[] arrOfStr = origString.split(" ");
		for (int index = arrOfStr.length - 1; index >= 0; index--) {
			collectwordStrings.add(arrOfStr[index]);
		}
		for (String i : collectwordStrings) {
			System.out.print(i);
			//System.out.print(i + " ");
		}

	}

	/**
	 * Implement .split method. split should take a character as input and returns
	 * an array of strings.
	 * 
	 * INPUT: ("Reverse me if you can", " ") OUTPUT: ["Reverse", "me", "if", "you",
	 * "can"]
	 * 
	 * @param origString
	 * @return stringArr
	 */
	public static ArrayList<String> splitMethod(String origString, char limit) {
		// create arraList to collect the characters of the origString
		ArrayList<Character> charArr = new ArrayList<Character>();
		for (int index = 0; index < origString.length(); index++) {
			charArr.add(origString.charAt(index));
		}

		// create arraList to add the characters in a string add add it inside the
		// arraList
		ArrayList<String> stringArr = new ArrayList<String>();
		String collectChar = "";
		for (int index = 0; index < charArr.size(); index++) {
			collectChar = collectChar + Character.toString(charArr.get(index));
			if (charArr.get(index) == limit) {
				stringArr.add(collectChar);
				collectChar = "";
			} else if (index == charArr.size() - 1) {
				stringArr.add(collectChar);
			}
		}
		return stringArr;
	}
	public static void reverseSentance(String origString) {
		ArrayList<String> collectwordStrings = new ArrayList<String>();
		String[] arrOfStr = origString.split(" ");

		for (int index = arrOfStr.length - 1; index >= 0; index--) {
			collectwordStrings.add(arrOfStr[index]);
		}
		for (String i : collectwordStrings) {
			System.out.print(i+ " ");
		}

	}
	
	public static void splitWithout(String origString) {
		// create arraList to collect the characters of the origString
	    Stack<String> collectStack = new Stack<String> ();
		String collectChar = "";
		for (int index = 0; index < origString.length(); index++) {
			collectChar = collectChar + Character.toString(origString.charAt(index));
			
			if(origString.charAt(index) == ' ') {
				collectStack.add(collectChar);
				collectChar = "";
			}else if (index == origString.length()-1) {
				collectStack.add(collectChar+ ' ');
			}
	
		}
		for(int index =collectStack.size()-1; index>=0; index--) {
			System.out.print(collectStack.get(index));
		}
				
//		String collectChar = "";
//		for (int index = 0; index < charArr.size(); index++) {
//			
//			if (charArr.get(index) == ' ') {
//				stringArr.add(collectChar);
//				collectChar = "";
//			} else if (index == charArr.size() - 1) {
//				stringArr.add(collectChar);
//			}
//		}
	}

}
