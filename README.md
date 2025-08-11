# Mastering Methods and Encapsulation
### Cadet Name: Rafael Nico T. Maniquiz

## Guided Java Lab: Mastering Methods and Encapsulation

Welcome to the Java Lab on Methods and Encapsulation\!

This hands-on lab will guide you through the essential concepts of creating and using methods, understanding how Java handles parameters, and the fundamental principle of encapsulation. By the end of this lab, you will have a solid foundation in these core Java features.

For each topic, you will follow a simple, effective learning path:

1.  **Predict the Output:** Challenge yourself by analyzing a code snippet and guessing the outcome.
2.  **Run the Program:** Compile and execute the code to see the real-world result.
3.  **Complete a Mini Challenge:** Apply what you've learned by writing your own code to solve a problem.

Let's get started!

-----

## 1. Designing Methods

Methods are the building blocks of Java programs. They are named blocks of code that perform a specific task and can be executed whenever needed. Proper method design is key to writing organized, reusable, and readable code. A method's declaration consists of an access level, a return type, a unique name, and a list of parameters.

**Code Snippet**

```java
public class Car {
    public void startEngine() {
        System.out.println("Engine has started.");
    }

    public String drive(int speed) {
        return "The car is moving at " + speed + " mph.";
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.startEngine();
        String status = myCar.drive(60);
        System.out.println(status);
    }
}
```

**1. Prediction**

```
Engine has started.
The car is moving at 60 mph.
```

**2. Observation**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/1.png"/>

### Mini Challenge

Inside the `Car` class, add a new method named `turnOffEngine`. This method should not return any value and should print the message "Engine has been turned off." to the console. Modify the `main` method to call `turnOffEngine` after the car's status has been printed.

**Sample Output**

```
Engine has started.
The car is moving at 60 mph.
Engine has been turned off.
```

**Code**

```java
public class Car {
    /*
            other instance methods
     */

    public void turnOffEngine() {
        System.out.println("Engine has been turned off.");
    }

    /*
            main method
     */
}

```
**Code Output**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/1-mini.png"/>
-----

## 2. Passing Parameters: Primitives vs. Objects

Java passes all method arguments by **value**. This can be tricky. For primitive types (int, `char`, `double`, etc.), this means a copy of the value is passed. For objects, a copy of the **reference** (the memory address) to the object is passed. Understanding this distinction is crucial.

**Code Snippet**

```java
public class ParameterPassing {
    public static void modifyValue(int value) {
        value = 100;
        System.out.println("Inside method: " + value);
    }

    public static void main(String[] args) {
        int originalValue = 50;
        System.out.println("Before method call: " + originalValue);
        modifyValue(originalValue);
        System.out.println("After method call: " + originalValue);
    }
}
```

**1. Prediction**

```
Before method call: 50
Inside method: 100
After method call: 50
```

**2. Observation**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/2.png"/>

### Mini Challenge

Create a `Student` class with a single instance variable, `name` (a `String`). In a separate `Main` class, write a `main` method where you create a `Student` object. Also in the `Main` class, create a method `changeStudentName(Student student, String newName)` that takes a `Student` object and a new name, and changes the student's name using the object reference. In `main`, call this method and print the student's name before and after the call to prove that the original object was modified.

**Sample Output**

```
Name before change: Alex
Name after change: Jordan
```

**Code**

```java
class Student{
    String name;
    Student(String name){
        this.name = name;
    }

    /*
            getters and setters
     */
}

public class ParameterPassing {
    public static void changeStudentName(Student student, String newName){
        student.setName(newName);
    }
    public static void main(String[] args) {
        {
            Student student = new Student("Alex");
            System.out.println("Name before change: " + student.getName());
            changeStudentName(student, "Jordan");
            System.out.println("Name after change: " + student.getName());
        }
    }
}

```
**Code Output**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/2-mini.png"/>
-----

## 3. Using Varargs

Varargs (variable-length arguments) provide a flexible way to create methods that can accept zero or more arguments of a specific type. This is declared by using an ellipsis (`...`) after the data type in the parameter list.

**Code Snippet**

```java
public class VarargsExample {
    public static void printMessages(String... messages) {
        System.out.println("Number of messages: " + messages.length);
        for (String msg : messages) {
            System.out.print(msg + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        printMessages("Hello", "World");
        printMessages("Testing", "Varargs", "Here");
        printMessages();
    }
}
```

**1. Prediction**


```
Number of messages: 2
Hello World 

Number of messages: 3
Testing Varargs Here 

Number of messages: 0

```

**2. Observation**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/3.png"/>

### Mini Challenge

Create a method named `findLargest` that takes a variable number of integers (`int... numbers`) and returns the largest integer from the list. If no numbers are provided, it should return `Integer.MIN_VALUE`. Test this method in `main` by calling it with different sets of numbers, including an empty call.

**Sample Output**

```
Largest in (10, 5, 25, 15) is: 25
Largest in (-5, -1, -10) is: -1
Largest with no numbers is: -2147483648
```

**Code**

```java
public class VarargsExample {
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
        int largestNumber;
        largestNumber = findLargest(10, 5, 25, 15);
        largestNumber = findLargest(-5, -1, -10);
        largestNumber = findLargest();
    }
}


```
**Code Output**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/3-mini.png"/>
-----

## 4. Access Specifiers

Access specifiers control the visibility and accessibility of classes, methods, and variables. They are crucial for encapsulation and for defining a class's public API.

* **`public`**: Accessible from any other class.
* **`private`**: Accessible only within the declaring class.
* **`protected`**: Accessible within the same package and by subclasses.
* **`default`** (no specifier): Accessible only within the same package.

**Code Snippet**

```java
// In a file named Account.java
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

// In a file named Bank.java
public class Bank {
    public static void main(String[] args) {
        Account myAccount = new Account();
        myAccount.displayAccountDetails();
        // The following line would cause a compile-time error if uncommented
        // System.out.println(myAccount.balance);
    }
}
```

**1. Prediction**

```
Alice has a balance of $1200.50
```

**2. Observation**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/4.png"/>

### Mini Challenge

Create a `SmartDoor` class. It should have a `private` boolean instance variable `isLocked`. It should also have three `public` methods: `lockDoor()`, `unlockDoor()`, and `isLocked()`. The first two methods should change the state of the `isLocked` variable, and the third should return its current state.

**Sample Output**

```
Is the door locked? false
Locking the door...
Is the door locked? true
Unlocking the door...
Is the door locked? false
```

**Code**

```java
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

```
**Code Output**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/4-mini.png"/>
-----

## 5. Static Methods and Variables

The `static` keyword signifies that a method or variable belongs to the **class itself**, rather than to a specific instance (object) of the class. This means you can call a static method using the class name, without needing to create an object first.

**Code Snippet**

```java
public class Utility {
    public static String getAppName() {
        return "My Awesome App";
    }

    public String getInstanceId() {
        return "ID-12345";
    }

    public static void main(String[] args) {
        System.out.println("App Name: " + Utility.getAppName());
        // The following line would cause a compile-time error
        // System.out.println("Instance ID: " + Utility.getInstanceId());
        Utility utilInstance = new Utility();
        System.out.println("Instance ID: " + utilInstance.getInstanceId());
    }
}
```

**1. Prediction**

```
App Name: My Awesome App
Instance ID: ID-12345
```

**2. Observation**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/5.png"/>

### Mini Challenge

Create a `Converter` class. It should have a `static` method `celsiusToFahrenheit(double celsius)` that takes a temperature in Celsius and returns the equivalent in Fahrenheit. The formula is `(celsius * 9.0/5.0) + 32`. In the `main` method, call this static method without creating an instance of `Converter` and print the result. (Note: use `9.0/5.0` to ensure floating-point division).

**Sample Output**

```
25.0 degrees C is 77.0 degrees F.
```

**Code**

```java
class Converter {
    static double celsiusToFahrenheit(double celsius){
        double fahrenheit = (celsius * 9.0/5.0) + 32;
        System.out.println(celsius + " degrees C is " + fahrenheit + " degrees F.");

        return fahrenheit;
    }
}
```
**Code Output**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/5-mini.png"/>
-----

## 6. Method Overloading

Method overloading allows a class to have multiple methods with the same name, provided their parameter lists are different. This can be a difference in the number of parameters, the type of parameters, or both. It improves code readability by allowing you to use the same method name for similar operations.

**Code Snippet**

```java
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
```

**1. Prediction**


```
Number: 42
Message: Hello
Repeating Message:
Goodbye
Goodbye
Goodbye
```

**2. Observation**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/6.png"/>

### Mini Challenge

In the `Converter` class from the previous challenge, overload the conversion method. Create a second `static` method, `fahrenheitToCelsius(double fahrenheit)`, that converts a temperature from Fahrenheit to Celsius. The formula is `(fahrenheit - 32) * 5.0/9.0`. Test both methods in `main`.

**Sample Output**

```
25.0 degrees C is 77.0 degrees F.
77.0 degrees F is 25.0 degrees C.
```

**Code**

```java
class Converter {
    static double celsiusToFahrenheit(double celsius){
        double fahrenheit = (celsius * 9.0/5.0) + 32;
        System.out.println(celsius + " degrees C is " + fahrenheit + " degrees F.");

        return fahrenheit;
    }

    static double celsiusToFahrenheit(double temp, boolean inverse){
        if (inverse) return fahrenheitToCelsius(temp);
        double fahrenheit = (temp * 9.0/5.0) + 32;
        System.out.println(temp + " degrees C is " + fahrenheit + " degrees F.");

        return fahrenheit;
    }

    static double fahrenheitToCelsius(double fahrenheit){
        double celsius = (fahrenheit - 32) * 5.0/9.0;
        System.out.println(fahrenheit + " degrees F is " + celsius + " degrees C.");

        return celsius;
    }
}
```
**Code Output**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e3e7d60f5cd0e9a451efce8fb9550430edbd096f/screenshots/6-mini-new.png"/>
-----

## 7. Constructors and Constructor Overloading

A constructor is a special method called when an object is instantiated. Its purpose is to initialize the new object. Constructors must have the same name as the class and do not have a return type. Just like methods, constructors can be overloaded.

**Code Snippet**

```java
public class Pizza {
    private String toppings;
    private int size; // in inches

    public Pizza() {
        this.toppings = "Cheese";
        this.size = 12;
        System.out.println("Default pizza created.");
    }

    public Pizza(String toppings) {
        this(); // Calls the no-argument constructor first
        this.toppings = toppings;
        System.out.println("Pizza with custom toppings created.");
    }

    public Pizza(String toppings, int size) {
        this.toppings = toppings;
        this.size = size;
        System.out.println("Fully custom pizza created.");
    }

    public void display() {
        System.out.println("Size: " + size + " inches, Toppings: " + toppings);
    }

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza();
        pizza1.display();

        Pizza pizza2 = new Pizza("Pepperoni");
        pizza2.display();

        Pizza pizza3 = new Pizza("Mushroom and Onion", 16);
        pizza3.display();
    }
}
```

**1. Prediction**

```
Default pizza created.
Size: 12 inches, Toppings: Cheese
Default pizza created.
Pizza with custom toppings created.
Size: 12 inches, Toppings: Pepperoni
Fully custom pizza created.
Size: 16 inches, Toppings: Mushroom and Onion
```

**2. Observation**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/7.png"/>

### Mini Challenge

Create a `Computer` class with `brand` (String) and `ramInGB` (int) as instance variables. Create three constructors:

1.  A default constructor setting `brand` to "Generic" and `ramInGB` to 8.
2.  A constructor that only takes a `brand` and uses the default RAM.
3.  A constructor that takes both `brand` and `ramInGB`.

Use constructor chaining (`this()`) to avoid repeating code. In `main`, create an object using each constructor and print its details.

**Sample Output**

```
Computer 1: Brand = Generic, RAM = 8GB
Computer 2: Brand = Dell, RAM = 8GB
Computer 3: Brand = Apple, RAM = 16GB
```

**Code**

```java
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

```
**Code Output**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/7-mini.png"/>
-----

## 8. Encapsulation

Encapsulation is a core principle of object-oriented programming. It means bundling the data (instance variables) and the methods that operate on that data within a single unit (a class). A key part of this is data hiding, usually achieved by making variables `private` and providing `public` methods (getters and setters) to access and modify them. This protects the data from invalid or unintended changes.

**Code Snippet**

```java
public class Thermostat {
    private double temperatureCelsius;

    public Thermostat(double temp) {
        // Use the setter in the constructor to enforce rules from the start
        setTemperatureCelsius(temp);
    }

    public double getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    public void setTemperatureCelsius(double temp) {
        if (temp >= 10.0 && temp <= 30.0) {
            this.temperatureCelsius = temp;
        } else {
            System.out.println("Error: Temperature must be between 10.0 and 30.0 Celsius.");
        }
    }

    public static void main(String[] args) {
        Thermostat stat = new Thermostat(22.5);
        System.out.println("Initial temp: " + stat.getTemperatureCelsius());

        stat.setTemperatureCelsius(5.0); // Try to set an invalid temp
        System.out.println("Temp after invalid change: " + stat.getTemperatureCelsius());

        stat.setTemperatureCelsius(25.0); // Set a valid temp
        System.out.println("Temp after valid change: " + stat.getTemperatureCelsius());
    }
}
```

**1. Prediction**

```
Initial temp: 22.5
Error: Temperature must be between 10.0 and 30.0 Celsius.
Temp after invalid change: 22.5
Temp after valid change: 25.0
```

**2. Observation**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/8.png"/>

### Mini Challenge

Create a `User` class with a `private` instance variable for a `password` (String).

* Provide a `public` getter, `getPassword()`, that returns a masked password (e.g., "\*\*\*\*\*\*\*\*").
* Provide a `public` setter, `setPassword(String password)`, that only sets the new password if it is at least 8 characters long. If it's too short, print an error message and do not change the password.
* Create a constructor that initializes the password using the setter.

In `main`, test your class by creating a user, trying to set a short password, then a valid one, and printing the masked password each time.

**Sample Output**

```
Error: Password must be at least 8 characters long.
Current masked password: ********
Attempting to set short password 'pass'...
Error: Password must be at least 8 characters long.
Current masked password: ********
Attempting to set valid password 'secure_password_123'...
Current masked password: *******************
```

**Code**

```java
package org.example;

public class User {
    private String password;

    User(String password){
        setPassword(password);
    }

    public String getPassword() {
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < password.length() ; i++) masked.append("*");
        return masked.toString();
    }

    public void setPassword(String password){
        if (password.length() < 8){
            System.out.println("Error: Password must be at least 8 characters long.");
        } else this.password = password;
    }

    public static void main(String... args) {
        System.out.println("Creating a user with password 'Password'");
        User user = new User("Password");
        System.out.println("Current masked password: " + user.getPassword());
        System.out.println("Attempting to set short password 'pass'...");
        user.setPassword("pass");
        System.out.println("Current masked password: " + user.getPassword());
        System.out.println("Attempting to set valid password 'secure_password_123'...");
        user.setPassword("secure_password_123");
        System.out.println("Current masked password: " + user.getPassword());
    }
}

```

**Code Output**

<img src="https://github.com/rick-maniquiz/JC-Exploring-Methods-and-Encapsulation/blob/e768c58cf36bb344676742a261b1ff3762bd7eab/screenshots/8-mini.png"/>