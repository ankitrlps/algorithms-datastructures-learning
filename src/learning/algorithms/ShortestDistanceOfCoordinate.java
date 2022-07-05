package learning.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * c = ["c1", "c2", "c3"]
 * x = [3, 2, 1]
 * y = [3, 2, 3]
 * q = ["c1", "c2", "c3"]
 */

public class ShortestDistanceOfCoordinate {

    private static List<String> calculateDistance(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
        List<String> cities = new ArrayList<>();
        q.forEach(city -> {
            if (!c.contains(city)) {
                cities.add("None");
            } else {
                int cIndex = c.indexOf(city);
                int xCord = x.get(x.indexOf(cIndex));
                int yCord = y.get(y.indexOf(cIndex));
                boolean status = false;
                if (x.contains(xCord) && x.get(x.indexOf(cIndex)) != xCord) {
                    status = true;
                }

                if (y.contains(yCord) && y.get(y.indexOf(cIndex)) != yCord) {
                    status = true;
                }
                if (status)
                    cities.add(city);
            }
        });
        return cities;
    }

    public static void main(String[] args) {

    }
    private int[] test () {
        int[] i = new int[2];
        return new int[] {1, 3};
    }
}
