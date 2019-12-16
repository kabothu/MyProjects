package com.krishna.strings;

class StringPalindromeSolution {
	
	public static boolean testStringPalindrome(String str) {
		
		int mid = str.length()/2;
		int length = str.length();
		boolean n = false;
		for(int i=0;i<mid;i++) {
			
			if(str.charAt(i) == str.charAt(length-1)) {
				length--;
				n = true;
			}else {
				n = false;
			}
			if(n == false)
				break;
		}
		return n;
	}
}

public class StringPalindrome {

	public static void main(String[] args) {
		String str ="abbacbabba";
		System.out.println(StringPalindromeSolution.testStringPalindrome(str));

	}

}
