package org.example;

public class SmartDoor {
    private boolean isLocked = false;
    public void lockDoor(){
        System.out.println("Locking the door...");
        isLocked = true;
    }
    public void unlockDoor(){
        System.out.println("Unlocking the door...");
        isLocked = false;
    }
    public boolean isLocked(){
        return isLocked;
    }
}
