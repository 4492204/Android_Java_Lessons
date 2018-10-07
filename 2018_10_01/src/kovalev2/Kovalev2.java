package kovalev2;

import java.time.LocalDateTime;

public class Kovalev2 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.getDayOfWeek());
        System.out.println(now.getMonth());
        System.out.println("Vasilii");
    }
}
