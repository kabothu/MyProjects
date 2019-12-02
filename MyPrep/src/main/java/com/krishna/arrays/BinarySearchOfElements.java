package com.krishna.arrays;

//https://www.youtube.com/watch?v=j5uXyPJ0Pew

//https://www.geeksforgeeks.org/binary-search/

// https://www.youtube.com/watch?v=-bQ4UzUmWe8

class BinarySearch {

	public static int testBinarySearch(int[] array, int key) {

		int start = 0;
		int end = array.length - 1;
		int mid;

		while (start <= end) {

			mid = (start + end) / 2;

			if (key == array[mid]) {
				return mid;
			} else if (key < array[mid]) {
				end = mid - 1;
			} else if (key > array[mid]) {
				start = mid + 1;
			}
		}
		return -1;
	}
}

public class BinarySearchOfElements {

	public static void main(String[] args) {
		int[] array = { 2, 6, 13, 21, 36, 47, 63, 81, 97 };
		int result = BinarySearch.testBinarySearch(array, 13);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);

	}

}
