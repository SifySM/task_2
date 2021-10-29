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

        analyzeLocationCircles(x1, y1, r1, x2, y2, r2);

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

        if ((name == "r1") || (name == "r2")) {
            while (value <= 0) {
                System.out.println("Invalid input. Re-enter the data. r>0. ");
                value = readDouble(name);
            }
        }
            return value;
    }

    static double compare(double x1, double x2) {
        final double e = 0.1;

        if (Math.abs(x1 - x2) <= e)
            return 0;
        else return x1 - x2;

    }

    static void analyzeLocationCircles(double x1, double y1, double r1, double x2, double y2, double r2) {
        double dist = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        if (compare(dist, r2 + r1) > 0) {
            System.out.println("Circles do not intersect, do not fit into one another");
        } else {
            if (compare(dist, r2 + r1) == 0) {
                System.out.println("Circles touch externally - one common point");
            } else {
                if (compare(dist, Math.abs(r2 - r1)) > 0) {
                    System.out.println("Circles intersect at two points");
                }
            }
        }

        if (compare(dist, Math.abs(r2 - r1)) == 0) {
            System.out.println("Circles touch (1 common point) on the inside");
        }

        if (compare(dist, Math.abs(r2 - r1)) < 0) {
            System.out.println("Circles one circle does not intersect inscribed in another");
        }
    }
}
