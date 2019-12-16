package com.krishna.strings;

import java.util.HashMap;
import java.util.Stack;

class ClosedParanthesisSolution {

	public static boolean testClosedParanthesisSolution(String str) {

		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {

				st.push(str.charAt(i));

			} else {
				if (st.isEmpty()) {
					return false;
				} else {
					char pop_value = st.pop();
					if (str.charAt(i) == ')' && pop_value != '(') {
						return false;
					} else if (str.charAt(i) == ']' && pop_value != '[') {
						return false;
					} else if (str.charAt(i) == ']' && pop_value != '[') {
						return false;
					}
				}
			}
		}
		if (st.isEmpty()) {
			return true;
		}
		return false;

	}
}

public class ClosedParanthesis {

	public static void main(String[] args) {
		String str ="([()])";
		System.out.println(ClosedParanthesisSolution.testClosedParanthesisSolution(str));

	}

}
