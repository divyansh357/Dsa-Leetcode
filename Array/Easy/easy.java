package Array.Easy;

public class easy {
    
    //3300. Minimum Element After Replacement With Digit Sum

    
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++) nums[i] = digitSum(nums[i]);
        return min(nums);
    }
    public int min(int[] nums){
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min) min = nums[i];
        }
        return min;
    }
    public int digitSum(int n){
        int sum =0;
        while(n>0){
            sum+= n%10;
            n/=10;
        }
        return sum;
    }

}
