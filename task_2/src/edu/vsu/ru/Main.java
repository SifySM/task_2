package edu.vsu.ru;

public class Main {

    public static void main(String[] args) {
        if (!LocationCircles.readValues()) {
            System.out.println("The data is not correct! Please try again.");
        } else LocationCircles.analyzeLocationCircles();
    }
}
