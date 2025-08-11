package org.example;

public class Display {

    public void show(String message) {
        System.out.println("Message: " + message);
    }

    public void show(String message, int times) {
        System.out.println("Repeating Message:");
        for (int i = 0; i < times; i++) {
            System.out.println(message);
        }
    }

    public void show(int number) {
        System.out.println("Number: " + number);
    }

    public static void main(String[] args) {
        Display d = new Display();
        d.show(42);
        d.show("Hello");
        d.show("Goodbye", 3);
    }
}
