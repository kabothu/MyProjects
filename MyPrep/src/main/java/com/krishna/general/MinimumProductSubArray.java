package com.krishna.general;

class MinimumProductSubArraySolution {
	
	public static int testMinimumProductSubArray(int[] nums) {
		
		if(nums==null || nums.length==0) {
			return 0;
		}
		
		int current_min = nums[0];
		int current_max = nums[0];
		int final_min = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			
			int temp = current_max;
			
			current_max = Math.max(Math.max(current_max * nums[i], current_min * nums[i]), nums[i]);
			current_min = Math.min(Math.min(temp * nums[i], current_min * nums[i]), nums[i]);
			
			if(current_min<final_min) {
				final_min = current_min;
			}
		}
		
		return final_min;
	}
}

public class MinimumProductSubArray {

	public static void main(String[] args) {
		int[] nums = {-20,-9,0,1,2,3,9,16,15};
		System.out.println(MinimumProductSubArraySolution.testMinimumProductSubArray(nums));

	}

}
