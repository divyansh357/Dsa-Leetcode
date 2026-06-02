package Array.Easy;

import java.util.Arrays;

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

    // 2144. Minimum Cost of Buying Candies With Discount

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;

        for (int i = cost.length - 1; i >= 0; i -= 3) {
            total += cost[i];
            if (i - 1 >= 0)
                total += cost[i - 1];
        }

        return total;
    }


    // 3633. Earliest Finish Time for Land and Water Rides I
    public int earliestFinishTime(int[] startL, int[] durL, int[] startW, int[] durW) {
        int minL = 3000, minW = minL, res = minW;
        int n = startL.length;
        int m = startW.length;

        for (int i = 0; i < n; i++)
            minL = Math.min(minL, startL[i] + durL[i]);

        for (int i = 0; i < m; i++) {
            minW = Math.min(minW, startW[i] + durW[i]);
            res = Math.min(res, Math.max(minL, startW[i]) + durW[i]);
        }

        for (int i = 0; i < n; i++)
            res = Math.min(res, Math.max(minW, startL[i]) + durL[i]);

        return res;
    }
}
