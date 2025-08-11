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
