package learning;

public class Reverse {
    public static int reverse(int x) {

        boolean isminus = false;
        if (x < 0) {
            isminus = true;
            x *= -1;
        }
        String s = String.valueOf(x);
        char[] c = s.toCharArray();
        char[] reverse = new char[c.length];

        for (int i = c.length - 1, j = 0; i >= 0; i--) {
            reverse[j++] = c[i];
        }

        try {
            int num = Integer.valueOf(String.valueOf(reverse));
            return isminus ? -1 * num : num;
        } catch (NumberFormatException e) {
            return 0;
        }

    }
}
