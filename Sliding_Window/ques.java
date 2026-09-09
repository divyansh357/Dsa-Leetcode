package Sliding_Window;

public class ques {

    // 643. Maximum Average Subarray I
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;
        double currSum=0;
        for(int right=0; right<nums.length; right++){
            currSum+=nums[right];
            if(right-left+1==k){
                maxAvg = Math.max( (double)currSum/k , maxAvg);
                currSum-=nums[left];
                left++;
            } 
        }
        return maxAvg;
    }
    
}
