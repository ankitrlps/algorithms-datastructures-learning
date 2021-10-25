package learning.algorithms;

/**
 * Counts the number of alphabets before finds a new one from previous.
 *
 * aabbbss -> a2b3s2
 */
public class RunLengthEncoding {

    public static void main(String[] args) {
        encodeString("aabbccde");
    }

    private static void encodeString(String input) {
        if (input.length() == 0) {
            return;
        }
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = '\u0000'; // \u0000 denotes null for character datatype
        for (char aChar : chars) {
            if (prev != '\u0000' && aChar != prev) {
                sb.append(prev).append(count);
                count = 0;
            }
            count++;
            prev = aChar;
        }
        if (count > 0) {
            sb.append(prev).append(count);
        }
        System.out.println(sb);
    }
}
