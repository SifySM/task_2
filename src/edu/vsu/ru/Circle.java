package edu.vsu.ru;

import java.util.Locale;
import java.util.Scanner;

public class Circle {
    double x;
    double y;
    double r;
    int n;


    public Circle(int n) {
        this.n = n;
    }

    public boolean readParameters() {
        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the parameters of the circle " + n + ":");

        System.out.print("x" + n + ": ");
        if (!scanner.hasNextDouble()) {
            return false;
        }
        x = scanner.nextDouble();

        System.out.print("y" + n + ": ");
        if (!scanner.hasNextDouble()) {
            return false;
        }
        y = scanner.nextDouble();

        System.out.print("r" + n + ": ");
        if (!scanner.hasNextDouble()) {
            return false;
        }
        r = scanner.nextDouble();
        return true;
    }

}
