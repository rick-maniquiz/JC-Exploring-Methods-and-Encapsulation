package org.example;

public class Computer {
    private String brand;
    private int ramInGb;
    private static int computerCount = 0;


    Computer(){
        this.brand = "Generic";
        this.ramInGb = 8;
        computerCount++;
    }

    Computer(String brand){
        this();
        this.brand = brand;
    }

    Computer(String brand, int ramInGb){
        this.brand = brand;
        this.ramInGb = ramInGb;
    }

    void display(){
        System.out.println("Computer " +
                computerCount +
                ": Brand = " +
                this.brand +
                ", RAM = " +
                this.ramInGb +
                "GB");
    }

    public static void main(String... args){
        new Computer().display();
        new Computer("Dell").display();
        new Computer("Apple", 16).display();
    }
}
