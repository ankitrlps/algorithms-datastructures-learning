package learning.algorithms;

public class FindNthRoot {
    
    private static double root(int num, int power) {
        double lower = 0;
        double higher = Integer.max(1, num);
        double approxRoot = (higher + lower) / 2;
        while (approxRoot - lower >= 0.001) {
            if (Math.pow(approxRoot, power) > num) {
                higher = approxRoot;
            } else if (Math.pow(approxRoot, power) < num) {
                lower = approxRoot;
            } else {
                break;
            }
            approxRoot = (higher + lower) / 2;
        }
        return approxRoot;
    }

    public static void main(String[] args) {
        System.out.println("Nth root of " + 7 + " power 3 " + root(9, 3));
    }
}
