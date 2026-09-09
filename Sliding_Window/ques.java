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
 
    //1456. Maximum Number of Vowels in a Substring of Given Length

    public int maxVowels(String s, int k) {
        int left = 0;
        int maxVowels = 0;
        int currVowels =0;
        for(int right =0;right<s.length();right++){
            if(s.charAt(right)=='a'||s.charAt(right)=='e'||s.charAt(right)=='i'||s.charAt(right)=='o'||s.charAt(right)=='u'){
                currVowels++;
            }
            if(right-left+1==k){
                maxVowels= Math.max(currVowels,maxVowels);
                if(s.charAt(left)=='a'||s.charAt(left)=='e'||s.charAt(left)=='i'||s.charAt(left)=='o'||s.charAt(left)=='u'){
                    currVowels--;
                }
                left++;
            }
        }
        return maxVowels; 
    }

    
}
