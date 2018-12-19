package learning;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {

        char[] text = s.toCharArray();
        int longestnum = 0;
        String longesttext = "";

        for (int i = 0; i < text.length; i++) {
            int j = i + 1, samechar = 0;
            while (j < text.length && text[j] == text[i]) {
                j++;
                samechar++;
            }

            int outsidelength = 0;
            // 左起i-1，右起i+samechar+1
            int k = i - 1, l = i + samechar + 1;
            while (k >= 0 && l < text.length) {
                if (text[k] != text[l]) {
                    break;
                }
                outsidelength++;
                k--;
                l++;
            }

            if (longestnum < (samechar + 1) + outsidelength * 2) {
                longestnum = (samechar + 1) + outsidelength * 2;
                longesttext = s.substring(k + 1, l);
            }

        }

        return longesttext;
    }
}
