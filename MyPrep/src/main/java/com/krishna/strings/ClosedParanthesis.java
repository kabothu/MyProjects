package com.krishna.strings;

import java.util.Stack;

class ClosedParanthesisSolution {

	public static boolean testClosedParanthesisSolution(String str) {

		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {

				st.push(str.charAt(i));

			} else if (str.charAt(i) == ')' && !st.isEmpty() && st.peek() == '(') {
				st.pop();
			} else if (str.charAt(i) == ']' && !st.isEmpty() && st.peek() == '[') {
				st.pop();
			} else if (str.charAt(i) == '}' && !st.isEmpty() && st.peek() == '{') {
				st.pop();
			} else {
				return false;
			}
		}

		return st.isEmpty();

	}
}

public class ClosedParanthesis {

	public static void main(String[] args) {
		String str = "([()])";
		System.out.println(ClosedParanthesisSolution.testClosedParanthesisSolution(str));

	}

}
