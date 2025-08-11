package org.example;

public class Account {
    private String owner = "Alice";
    private double balance = 1200.50;

    private String getDetails() {
        return owner + " has a balance of $" + balance;
    }

    public void displayAccountDetails() {
        // We can call the private method from within the class
        System.out.println(getDetails());
    }
}
