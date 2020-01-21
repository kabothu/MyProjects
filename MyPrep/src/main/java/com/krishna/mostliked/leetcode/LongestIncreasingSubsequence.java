package com.krishna.mostliked.leetcode;

//https://www.youtube.com/watch?v=mouCn3CFpgg

//https://leetcode.com/problems/longest-increasing-subsequence/

class LongestIncreasingSubsequenceSolution {
	
	
	//Solution -1 using dp O(n^2) - T and O(n) -S
	public static int testLongestIncreasingSubsequenceSolution(int[] nums) {
		if(nums == null || nums.length==0) {
			return 0;
		}
		
		int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        
        for (int i = 1; i < nums.length; i++ ) 
    	{ 
    		dp[i] = 1; 
    		for (int j = 0; j < i; j++ ) 
    			if ( nums[i] > nums[j] && dp[i] < dp[j] + 1) 
    				dp[i] = dp[j] + 1; 
    		max = Math.max(max, dp[i]);
    	} 
        return max;
	}
	
	//Solution -2 O(2^n)-T  Size of recursion tree will be 2^n
	// Space - O(n^2) - memory array of size n*n is used.
	
	
	public int lengthOfLIS(int[] nums) {
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }
	
}

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(LongestIncreasingSubsequenceSolution.testLongestIncreasingSubsequenceSolution(nums));
	}

}
