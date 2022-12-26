import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 */

/**
 * @author LAP-9
 *
 */
public class stackQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String originString = "Somthing";
		stackMethod(originString);
		System.out.println();
		System.out.println();
		String Parentheses = "}";
		calculateParenthesesWithStack(Parentheses);
	}

	public static void stackMethod(String origString) {
		Stack<Character> addElements = new Stack<Character>();
		for (int index = 0; index < origString.length(); index++) {

			addElements.push(origString.charAt(index));
		}
		while (!addElements.empty()) {
			System.out.print(addElements.pop());
		}
	}

	public static void calculateParenthesesWithStack(String origString) {
		Stack<Character> addElements = new Stack<Character>();
		int countOpenParentheses = 0;
		int countCloseParentheses = 0;
		for (int index = 0; index < origString.length(); index++) {
			char element = origString.charAt(index);
			
			if (element == '{') {
				countOpenParentheses++;
			} else if (element == '}') {
				countCloseParentheses++;
			}
			
			if (element == '{') {
				addElements.push(element);
			}

			if (element == '}') {
				if (!addElements.empty() && countOpenParentheses != 0) {
					addElements.pop();
				}
			}
		}
		if (addElements.empty() && countOpenParentheses != 0 && countOpenParentheses == countCloseParentheses) {
			System.out.println("valid");

		} else {
			System.out.println("Not valid");
		}
	}

}
