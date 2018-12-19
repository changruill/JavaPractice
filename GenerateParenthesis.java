package learning;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<String>();
        }

        List<String> list = new ArrayList<String>();
        jointParenthesis(n, 1, 0, list, "(");
        return list;
    }

    private static void jointParenthesis(int n, int left, int right, List<String> list, String prefix) {
        if (prefix.length() == 2 * n) {
            list.add(prefix);
            return;
        }

        if (left < n) {
            jointParenthesis(n, left + 1, right, list, prefix + "(");
        }
        if (left > right) {
            jointParenthesis(n, left, right + 1, list, prefix + ")");
        }
    }
}
