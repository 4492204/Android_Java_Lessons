package kovalev4;

import java.util.Scanner;

public class Kovalev4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("First number: ");
        int first = reader.nextInt();
        System.out.println("Second number: ");
        float second = reader.nextInt();

        System.out.println("first + second: " + (first + second));
        System.out.println("first / second: " + (first / second));
    }
}
