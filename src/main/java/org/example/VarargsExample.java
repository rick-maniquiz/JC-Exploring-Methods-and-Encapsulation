package org.example;

public class VarargsExample {
    public static void printMessages(String... messages) {
        System.out.println("Number of messages: " + messages.length);
        for (String msg : messages) {
            System.out.print(msg + " ");
        }
        System.out.println("\n");
    }

    public static int findLargest(int... nums){
        int largestInt = Integer.MIN_VALUE, counter = 0;

        if (nums.length != 0){
            System.out.print("Largest in (");
            for (int num : nums){
                if (num > largestInt) largestInt = num;
                System.out.print(num);
                if (counter++ < nums.length - 1) System.out.print(", ");
                else System.out.print(") is: ");
            }
        }
        else System.out.print("Largest with no numbers is: ");

        System.out.println(largestInt);
        return largestInt;
    }

    public static void main(String[] args) {
        {
            printMessages("Hello", "World");
            printMessages("Testing", "Varargs", "Here");
            printMessages();
        }

        {
            int largestNumber;
            largestNumber = findLargest(10, 5, 25, 15);
            largestNumber = findLargest(-5, -1, -10);
            largestNumber = findLargest();
        }

    }
}
