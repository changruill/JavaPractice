package learning;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        int minlength = Integer.MAX_VALUE;

        for (String s : strs) {
            minlength = Math.min(s.length(), minlength);
        }

        int i = 0;
        while (i < minlength) {
            char c = strs[0].charAt(i);
            boolean aresame = true;
            for (String s : strs) {
                if (s.charAt(i) != c) {
                    aresame = false;
                    break;
                }
            }
            if (aresame)
                i++;
            else
                break;
        }

        return strs[0].substring(0, i);
    }
}
