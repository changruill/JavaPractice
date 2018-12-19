package learning;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<>();
        String[] s = new String[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':
                    s[i] = "abc";
                    break;
                case '3':
                    s[i] = "def";
                    break;
                case '4':
                    s[i] = "ghi";
                    break;
                case '5':
                    s[i] = "jkl";
                    break;
                case '6':
                    s[i] = "mno";
                    break;
                case '7':
                    s[i] = "pqrs";
                    break;
                case '8':
                    s[i] = "tuv";
                    break;
                case '9':
                    s[i] = "wxyz";
                    break;
            }
        }

        return joint(s, 0, list, "");
    }

    private static List<String> joint(String[] s, int i, List<String> list, String prefix) {
        if (i < s.length - 1) {
            for (int j = 0; j < s[i].length(); j++) {
                list = joint(s, i + 1, list, prefix + s[i].charAt(j));
            }
        } else {
            for (int j = 0; j < s[i].length(); j++) {
                list.add(prefix + s[i].charAt(j));
            }
        }

        return list;
    }
}
