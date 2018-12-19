package learning;

public class Convert {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        char[] text = s.toCharArray();
        char[] converttext = new char[s.length()];
        int c = 0;

        for (int i = 1; i <= numRows; i++) {

            if (i == 1 || i == numRows) {
                int k = 0;
                while (true) {
                    int loc = i + 2 * k * (numRows - 1);
                    if (loc > s.length()) {
                        break;
                    }
                    converttext[c++] = text[loc - 1];
                    k++;
                }
            } else {
                int k = 0;
                while (true) {
                    int loc1 = i + 2 * k * (numRows - 1);
                    int loc2 = i + 2 * k * (numRows - 1) + (numRows - i) * 2;

                    if (loc1 > s.length()) {
                        break;
                    }
                    converttext[c++] = text[loc1 - 1];

                    if (loc2 > s.length()) {
                        break;
                    }
                    converttext[c++] = text[loc2 - 1];
                    k++;
                }

            }


        }

        return String.valueOf(converttext);


    }
}
