package org.example;

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