package learning.algorithms;

public class FindIsSquare {

    private static int check(Point p1, Point p2) {
        if ((p1.x - p2.x) == 0) {
            return Math.abs(p1.y - p2.y);
        } else if ((p1.y - p2.y) == 0) {
            return Math.abs(p1.x - p2.x);
        } else if (Math.abs(p1.x - p2.x) == Math.abs(p1.y - p2.y)) {
            return Math.abs(p1.x - p2.x);
        }
        return 0;
    }

    private static boolean isSquare(Point p1, Point p2, Point p3, Point p4) {
        int side1 = check(p1, p2);
        int side2 = check(p2, p3);
        int side3 = check(p3, p4);
        int side4 = check(p4, p1);
        return side1 == side2 && side2 == side3 && side4 == side1;
    }

    public static void main(String[] args) {
        System.out.println(isSquare(new Point(10, 23), new Point(26, 7), new Point(10, 7), new Point(26, 23)));
    }

     static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
