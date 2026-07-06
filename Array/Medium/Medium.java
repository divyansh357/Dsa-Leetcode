package Array.Medium;

public class Medium {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int maxasteroid = 0;
        for(int a : asteroids) {
            if(a > maxasteroid) maxasteroid = a;
        }
        
        int[] freq = new int[maxasteroid + 1];
        for(int a : asteroids) {
            freq[a]++;
        }
        
        long currentmass = mass;
        for(int i = 1; i <= maxasteroid; i++) {
            if(freq[i] > 0) {
                if(i > currentmass) return false;
                currentmass += (long) i * freq[i];
            }
        }
        
        return true;
    }


    // 3689. Maximum Total Subarray Value I
    public long maxTotalValue(int[] nums, int k) {
        long mx = 0;
        long mn = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > mx) mx = num;
            if (num < mn) mn = num;
        }

        return (mx - mn) * 1L * k;
    }
}


// 1288. Remove Covered Intervals
class Solution {
    public int removeCoveredIntervals(int[][] A) {
        Arrays.sort(A, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int res = 0, r = 0;

        for (int[] x : A) {
            if (x[1] > r) {
                r = x[1];
                res++;
            }
        }

        return res;
    }
}