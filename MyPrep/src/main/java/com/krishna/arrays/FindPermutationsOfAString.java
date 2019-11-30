package com.krishna.arrays;

//https://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html

//https://www.youtube.com/watch?v=GuTPwotSdYw

class PermutationSolution {

	public static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}
}

public class FindPermutationsOfAString {

	public static void main(String[] args) {
		PermutationSolution.permutation("", "ABC");

	}

}
