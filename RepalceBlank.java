public class RepalceBlank {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public static int replaceBlank(char[] string, int length)
    {
        if(string == null)
            return length;
        int blank_num = 0;

        for(char c : string)
            if(c == ' ')
                blank_num++;

        int length_after = length+2*blank_num;

        for(int i = length_after-1, j = length-1; i>=0 && j>=0; j--)
        {
            if(string[j] == ' ')
            {
                string[i--] = '0';
                string[i--] = '2';
                string[i--] = '%';
            }
            else
            {
                string[i] = string[j];
                i--;
            }
        }

        return length_after;
    }

}
