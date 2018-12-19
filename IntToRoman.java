package learning;

public class IntToRoman {
    public static String intToRoman(int num) {

        int[] intval = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romvalStrings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        String ans = "";
        while (num > 0 && num < 4000) {
            if (num >= intval[i]) {
                ans += romvalStrings[i];
                num -= intval[i];
            } else {
                i++;
            }
        }
        return ans;
    }
}
