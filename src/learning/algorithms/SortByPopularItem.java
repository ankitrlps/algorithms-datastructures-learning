package learning.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SortByPopularItem {

    static List<String> sortPopularItem(List<String> items) {
        return null;
    }

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("101");
        items.add("102");
        items.add("103");
        items.add("103");
        items.add("105");
        items.add("103");
        sortPopularItem(items).forEach(System.out::println);
    }
}
