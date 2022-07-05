package learning.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    public static String[] reorderLogFiles(String[] logs) {
        Comparator<String> compareLog = new Comparator<String>() {
            @Override
            public int compare(String l1, String l2) {
/*                 String identifier1 = l1.substring(0, l1.indexOf(" ") + 1);
                String identifier2 = l2.substring(0, l2.indexOf(" ") + 1);
                
                String value1 = l1.substring(l1.indexOf(" "), l1.length());
                String value2 = l2.substring(l2.indexOf(" "), l2.length()); */

                String[] keyValue1 = l1.split(" ", 2);
                String[] keyValue2 = l2.split(" ", 2);

                boolean isDigit1 = keyValue1[1].matches("[\\d\\s]+");
                boolean isDigit2 = keyValue2[1].matches("[\\d\\s]+");
                
                if (!isDigit1 && !isDigit2) {
                    if (keyValue1[1].compareTo(keyValue2[1]) == 0) { // if values are equal
                        return keyValue1[0].compareTo(keyValue2[0]); // then compare keys
                    }
                    return keyValue1[1].compareTo(keyValue2[1]); // compare values
                } else {
                    if (!isDigit1 && isDigit2) {
                        return -1;
                    } else if (isDigit1 && !isDigit2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
            
        };

        Arrays.sort(logs, compareLog);
        return logs;
    }

    public static void main(String[] args) {
        Arrays.asList(reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art zero can","dig2 3 6","let2 own kit dig","let3 art zero"})).forEach(System.out::print);;
    }
    
}
