package edu.vsu.ru;

public class LocationCircles {
    static Circle circle1 = new Circle(1);
    static Circle circle2 = new Circle(2);

    final static double e = 0.1;

    public static boolean readValues() {
        return (circle1.readParameters()) && (circle2.readParameters());
    }

    static double compare(double x1, double x2) {
        if (Math.abs(x1 - x2) <= e)
            return 0;
        else return x1 - x2;

    }

    public static void analyzeLocationCircles() {
        double dist = Math.sqrt((circle2.x - circle1.x) * (circle2.x - circle1.x) + (circle2.y - circle1.y) * (circle2.y - circle1.y));
        if (compare(dist, circle2.r + circle1.r) > 0) {
            System.out.println("Circles do not intersect, do not fit into one another");
        } else {
            if (compare(dist, circle2.r + circle1.r) == 0) {
                System.out.println("Circles touch externally - one common point");
            } else {
                if (compare(dist, Math.abs(circle2.r - circle1.r)) > 0) {
                    System.out.println("Circles intersect at two points");
                }
            }
        }

        if (compare(dist, Math.abs(circle2.r - circle1.r)) == 0) {
            System.out.println("Circles touch (1 common point) on the inside");
        }

        if (compare(dist, Math.abs(circle2.r - circle1.r)) < 0) {
            System.out.println("Circles one circle does not intersect inscribed in another");
        }
    }

}
