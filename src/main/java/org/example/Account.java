package org.example;

public class Account {
    private String owner = "Alice";
    private double balance = 1200.50;

    private String getDetails() {
        return owner + " has a balance of $" + balance;
    }

    public void displayAccountDetails() {
        System.out.println(getDetails());
    }
}
