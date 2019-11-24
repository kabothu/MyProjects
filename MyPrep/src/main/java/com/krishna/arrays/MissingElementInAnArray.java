package com.krishna.arrays;

//Solution-1

// (N+1)*(N+2)/2 - Sum of all elements in an array where N is length of array

// N*(N+1)/2 - Where N is the last element


//Solution-2

// XOR all the elements in an array using for loop like A1 ^ A2 ^ A4 ^ A5 ^ A6 and let it be X1

// XOR all elements from 1 to 6 in for loop A1 ^ A2 ^A3 ^ A4 ^ A5 ^ A6 and let it be X2

// XOR again X1 ^ X2

class MissingElement {

	public static int testMissingElement(int[] array) {

		int length = array.length;

		int nthElement = ((length + 1) * (length + 2)) / 2;

		int sumOfElements = 0;

		for (int i = 0; i < array.length; i++) {

			sumOfElements = sumOfElements + array[i];
		}

		return (nthElement - sumOfElements);

	}
}

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 5, 6 };

		System.out.println(MissingElement.testMissingElement(array));

	}

}
