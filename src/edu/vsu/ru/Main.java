package edu.vsu.ru;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the parameters of the circles");

        double x1 = readDouble("x1");
        double y1 = readDouble("y1");
        double r1 = readDouble("r1");

        double x2 = readDouble("x2");
        double y2 = readDouble("y2");
        double r2 = readDouble("r2");

        double dist = calculateDist(x1, y1, x2, y2);

        printLocation(analyzeLocationCircles(dist, r1, r2));

    }

    static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(name + " = ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Re-enter the data.");
            System.out.print(name + " = ");
            scanner.next();
        }
        double value = scanner.nextDouble();

        if ((name.equals("r1")) || (name.equals("r2"))) {
            while (value <= 0) {
                System.out.println("Invalid input. Re-enter the data. r>0. ");
                value = readDouble(name);
            }
        }
        return value;
    }

    static double calculateDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    static double compare(double x1, double x2) {
        final double e = 0.1;

        if (Math.abs(x1 - x2) <= e)
            return 0;
        else return x1 - x2;

    }

    static ELocation analyzeLocationCircles(double dist, double r1, double r2) {

        if (compare(dist, r2 + r1) > 0) {
            return ELocation.Outside;
        } else {
            if (compare(dist, r2 + r1) == 0) {
                return ELocation.OutsideTouch;
            } else {
                if (compare(dist, Math.abs(r2 - r1)) > 0) {
                    return ELocation.Intersect;
                }
            }
        }

        if (compare(dist, Math.abs(r2 - r1)) == 0) {
            return ELocation.InsideTouch;
        }

        if (compare(dist, Math.abs(r2 - r1)) < 0) {
            return ELocation.Inside;
        }
        return ELocation.Outside;
    }

    static final String[] LocationMess = {
        "Circles do not intersect, do not fit into each other.",
        "Circles touch (1 common point) on the inside.",
        "Circles intersect at two points.",
        "Circles touch externally - one common point.",
        "Circles one circle does not intersect inscribed in another."
    };

    static void printLocation (ELocation location){
        System.out.println("Circles location: " + LocationMess[location.ordinal()]);
    }
}
