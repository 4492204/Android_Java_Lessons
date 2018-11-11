package kovalev1;

import java.util.Scanner;

public class Kovalev1 {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int counter = 10;
        int secretNumber = 4;

        while (counter > 0) {
            System.out.println("Efforts remain: " + counter);
            System.out.println("Enter a number: ");
            int answer = reader.nextInt();

            if (counter > 1) {
                if (answer < secretNumber) {
                    System.out.println("Too small");
                } else if (answer > secretNumber) {
                    System.out.println("Too large");
                } else {
                    System.out.println("You guessed!");
                    counter = 0;
                }
            } else {
                System.out.println("You lose!");
            }

            counter--;
        }

        reader.close();
    }
}
