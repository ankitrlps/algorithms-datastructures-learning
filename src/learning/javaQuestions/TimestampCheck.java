package learning.javaQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TimestampCheck {

    private static List<Set<String>> verify(String[][] records) {
        List<Set<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            if (map.containsKey(records[i][0])) {
                List<String> li = map.get(records[i][0]);
                li.add(records[i][1]);
                map.put(records[i][0], li);
            } else {
                List<String> list = new ArrayList<>();
                list.add(records[i][1]);
                map.put(records[i][0], list);
            }
        }

        if (map.size() > 0) {
            Set<String> enterMiss = new HashSet<>();
            Set<String> exitMiss = new HashSet<>();
            res.add(enterMiss);
            res.add(exitMiss);
        }
        map.forEach((k, v) -> {
            int count = 0;
            for (String s : v) {
                if (s.equals("enter")) count += 1;
                if (s.equals("exit")) count -= 1;
                if (count < 0) {
                    count = 0; res.get(1).add(k);
                }
                if (count > 1) {
                    count = 0;
                    res.get(0).add(k);
                }
            }
            if (count < 0) res.get(1).add(k);
            if (count == 1) res.get(0).add(k);
        });
        return res;
    }

    public static void main(String[] argv) {
        String records1[][] = new String[][] {
                { "Martha", "exit" },
                { "Paul", "enter" },
                { "Martha", "enter" },
                { "Steve", "enter" },
                { "Martha", "exit" },
                { "Jennifer", "enter" },
                { "Paul", "enter" },
                { "Curtis", "exit" },
                { "Curtis", "enter" },
                { "Paul", "exit" },
                { "Martha", "enter" },
                { "Martha", "exit" },
                { "Jennifer", "exit" },
                { "Paul", "enter" },
                { "Paul", "enter" },
                { "Martha", "exit" },
                { "Paul", "enter" },
                { "Paul", "enter" },
                { "Paul", "exit" },
                { "Paul", "exit" }
        };

        String records2[][] = new String[][] {
                { "Paul", "enter" },
                { "Paul", "exit" },
        };

        String records3[][] = new String[][] {
                { "Paul", "enter" },
                { "Paul", "enter" },
                { "Paul", "exit" },
                { "Paul", "exit" },
        };

        String records4[][] = new String[][] {
                { "Paul", "enter" },
                { "Paul", "exit" },
                { "Paul", "exit" },
                { "Paul", "enter" },
        };

        System.out.println(verify(records1));
    }

}
