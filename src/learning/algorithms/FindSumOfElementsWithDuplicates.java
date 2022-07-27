package learning.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSumOfElementsWithDuplicates {

    static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public String toString() {
            return "Pair [a=" + a + ", b=" + b + "]";
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + a;
            result = prime * result + b;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (a != other.a)
                return false;
            if (b != other.b)
                return false;
            return true;
        }
    }

    private static List<Pair> sum (int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Pair> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                Pair p = new Pair(sum - arr[i], arr[i]);
                if (!res.contains(p)) res.add(p);
            } else {
                map.put(arr[i], sum - arr[i]);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        sum(new int[]{0, 1, 2, 3, 0, 1, 2, 3}, 4).forEach(System.out::println);
    }
}
