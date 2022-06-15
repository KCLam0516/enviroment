import java.util.Arrays;
class kUnique {
    public static void main(String[] args) {
        String asd = "2aabbcbbbadef";
        System.out.println(kUniques(asd));
    }

    public static String kUniques(String a) {
        //remove first character
        String sTarget = a.substring(1);
        //uniqueCharacterLimit
        int uniques = Integer.parseInt(String.valueOf(a.charAt(0)));
        //Total Character
        int[] count = new int[26];
        Arrays.fill(count, 0);

        int curr_start = 0, curr_end = 0;
        int max_window_size = 1;
        int max_window_start = 0;
        Arrays.fill(count, 0);

        count[sTarget.charAt(0) - 'a']++;
        for (int i = 1; i < sTarget.length(); i++) {
            count[sTarget.charAt(i) - 'a']++;
            curr_end++;
            while (!isValid(count, uniques)) {
                count[sTarget.charAt(curr_start) - 'a']--;
                curr_start++;
            }
            //+1 EX: character 0-2 = 3 character
            if (curr_end - curr_start + 1 > max_window_size) {
                max_window_size = curr_end - curr_start + 1;
                max_window_start = curr_start;
            }
        }
        return sTarget.substring(max_window_start, max_window_start + max_window_size);
    }

    static boolean isValid(int[] count, int uniques)
    {
        int val = 0;
        for (int i = 0; i < 26; i++)
        {
            if (count[i] > 0)
            {
                val++;
            }
        }
        return (uniques >= val);
    }
}
