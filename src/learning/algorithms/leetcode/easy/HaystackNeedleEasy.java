package learning.algorithms.leetcode.easy;

public class HaystackNeedleEasy {
    public static void main(String[] args) {
        System.out.print(haystackNeedleFirstOccurrenceIndex("hello", "ll"));
    }
    private static int haystackNeedleFirstOccurrenceIndex(String haystack, String needle) {
        if(needle == null || needle.isEmpty()) return 0;
        return haystack.contains(needle) ? haystack.indexOf(needle) : -1;
    }
}
