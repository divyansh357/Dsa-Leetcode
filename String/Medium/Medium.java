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

    // Relative Path
   public String relativePath(String s1, String s2) {

    // Remove the leading "/" so we don't get an empty element
    String[] arr1 = s1.substring(1).split("/");
    String[] arr2 = s2.substring(1).split("/");

    StringBuilder result = new StringBuilder("cd ");

    // Find the first directory where the paths differ
    int i = 0;

    while (i < arr1.length && i < arr2.length && arr1[i].equals(arr2[i])) {
        i++;
    }

    // Go up from s1 to the common directory
    for (int j = i; j < arr1.length; j++) {
        result.append("..");

        if (j != arr1.length - 1) {
            result.append("/");
        }
    }

    // If we had to go up and also need to go down
    if (i < arr1.length && i < arr2.length) {
        result.append("/");
    }

    // Go down into s2
    for (int j = i; j < arr2.length; j++) {
        result.append(arr2[j]);

        if (j != arr2.length - 1) {
            result.append("/");
        }
    }

    return result.toString();
}
}
}
