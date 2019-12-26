package com.krishna.mostliked.leetcode;

//Here I'm using XOR operation

//https://leetcode.com/problems/single-number/

class IntegerCountSolution {
	public static int singleNumber(int[] nums) {

		int result = 0;
        for(int x : nums){
            result = result ^ x;
        }
        return result;

	}
}

public class IntegerCount {

	public static void main(String[] args) {
		int[] nums = { -1 };
		System.out.println(IntegerCountSolution.singleNumber(nums));

	}

}
