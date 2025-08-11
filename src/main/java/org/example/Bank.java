package org.example;

public class Bank {
    public static void main(String[] args) {
        {
            Account myAccount = new Account();
            myAccount.displayAccountDetails();
        }

        System.out.println("");
        {
            SmartDoor smartDoor = new SmartDoor();
            System.out.println("Is the door locked? " + smartDoor.isLocked());
            smartDoor.lockDoor();
            System.out.println("Is the door locked? " + smartDoor.isLocked());
            smartDoor.unlockDoor();
            System.out.println("Is the door locked? " + smartDoor.isLocked());

        }
    }
}
