package com.krishna.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSpecialCharactersFromString {

	public static void main(String[] args) {
		String s = "Hel@#$%lo";
		String newString = "";
		Pattern pattern = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		for(int i=0; i<s.length();i++) {
			Matcher specialCharacters = pattern.matcher(String.valueOf(s.charAt(i)));
			
			if(!specialCharacters.find()) {
				newString = newString + s.charAt(i);
			}
			

		}
		System.out.println(newString);
	}

}
