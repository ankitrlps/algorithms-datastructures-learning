package learning.javaconcepts;

import java.util.HashMap;
import java.util.Map;

public class PassByValueAndReference {

    private int byValue(int i) {
        i = (i + 2);
        System.out.println("by value: " + i);
        return i+3;
    }

    public static void main(String[] args) {
        PassByValueAndReference andReference = new PassByValueAndReference();
        System.out.println("result: " + andReference.byValue(-1));
        Map<String, Integer> map = new HashMap<>();
        map.entrySet().forEach( v -> System.out.println(v.getKey() + " " + v.getValue()));

        int n = 29;
        int first = n/10;
        int second = n%10;
        System.out.println(first + second);
    }
    
}
