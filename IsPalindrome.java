package learning;

public class IsPalindrome {
    public static boolean isPalindrome(int x) {

        try {
            if (x < 0)
                return false;

            char[] c = String.valueOf(x).toCharArray();

            for (int i = 0, j = c.length - 1; i <= j; i++, j--) {
                if (c[i] != c[j])
                    return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
