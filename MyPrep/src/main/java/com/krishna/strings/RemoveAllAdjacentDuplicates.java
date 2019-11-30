package com.krishna.strings;

//https://stackoverflow.com/questions/15635585/remove-adjacent-duplicate-characters-in-a-stringjava-i-e-inputaaaabbbccdbbaae


class SingleOccurence {
	
	// Traverse from end to start of the string
	public static StringBuffer singleOccurence(String s) {
		StringBuffer sb = new StringBuffer(s);
		for (int i = sb.length() - 2; i >= 0; i--)
			if (sb.charAt(i) == sb.charAt(i + 1))
				sb.deleteCharAt(i + 1);
		return sb;
	}
}

public class RemoveAllAdjacentDuplicates {

	public static void main(String[] args) {
		
		System.out.println(SingleOccurence.singleOccurence("aaaabbbccdbbaae").toString());

	}

}
