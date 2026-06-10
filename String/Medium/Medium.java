package String.Medium;

public class Medium {

    //3121. Count the Number of Special Characters II
    public int numberOfSpecialChars(String word) {
        boolean[][] A = new boolean[2][27];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch & 31;
            int Case = (ch >> 5) & 1;

            A[Case][idx] = Case == 0 || !A[0][idx];
        }

        int res = 0;
        for (int i = 1; i < 27; i++)
            if (A[0][i] && A[1][i])
                res++;

        return res;
    }

    // 5. Longest Palindromic Substring
    public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <= s.length(); j++) {
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
}
