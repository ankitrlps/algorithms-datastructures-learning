package learning.algorithms.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of size n that has the following specifications: 

    - Each element in the array contains either a policeman or a thief.
    - Each policeman can catch only one thief.
    - A policeman cannot catch a thief who is more than K units away from the policeman.

    We need to find the maximum number of thieves that can be caught.
 */

public class PoliceThiefCatch {

    private static int catchThief(String[] arr, int k) {
        Queue<String> que = new LinkedList<>();
        int counterForK = 0; // starts from 1 to K
        int thiefCount = 0;
        for (String s : arr) {
            if (!que.isEmpty() && !que.peek().equals(s)) {
                thiefCount++;
                que.poll();
                //i = 1;
            } else {
                que.add(s);
                counterForK++;
            }
            if (counterForK > k && que.size() > k) {
                que.poll();
                counterForK = 1;
                //i--;
            }
        }
        return thiefCount;
    }

    public static void main(String[] args) {
        System.out.println("theives: " + catchThief(new String[] { "p", "p", "t", "t", "p" }, 1));
        System.out.println("theives: " + catchThief(new String[] { "p", "p", "t", "t", "p" }, 2));
        System.out.println("theives: " + catchThief(new String[] { "t", "t", "p", "p", "t", "p" }, 2));
        System.out.println("theives: " + catchThief(new String[] { "p", "t", "t", "p", "t" }, 1));
        System.out.println("theives: " + catchThief(new String[] { "p", "p", "p", "t", "p", "t", "t"}, 2));
        System.out.println("theives: " + catchThief(new String[] { "t", "p", "t", "t", "t", "t", "t", "p", "p", "p", "t"}, 4));
        System.out.println("theives: " + catchThief(new String[] { "t", "p", "t", "t", "t", "t", "t", "p", "p", "p", "t"}, 1));
        System.out.println("theives: " + catchThief(new String[] { "P", "T", "P", "T", "T", "P" }, 1));
    }
}
