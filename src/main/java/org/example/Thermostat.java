package org.example;

public class Thermostat {
    private double temperatureCelsius;

    public Thermostat(double temp) {
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

        stat.setTemperatureCelsius(5.0);
        System.out.println("Temp after invalid change: " + stat.getTemperatureCelsius());

        stat.setTemperatureCelsius(25.0);
        System.out.println("Temp after valid change: " + stat.getTemperatureCelsius());
    }
}