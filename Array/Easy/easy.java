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

// 1344. Angle Between Hands of a Clock
class Solution {
    public double angleClock(int hour, int minutes) {
        double x = hour + minutes / 60.0;
        double diff = (11.0 * x) % 12.0;
        return Math.min(diff, 12.0 - diff) * 30.0;
    }
}


//1929. Concatenation of Array
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }

    // 1470. Shuffle the Array

    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[2*n];
        int index = 0;
        for(int i = 0 ;i<n;i++){
            ans[index++] = nums[i];
            ans[index++] = nums[n+i];
        }
        return ans;
    }
