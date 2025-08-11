package org.example;

class Converter {
    static double celsiusToFahrenheit(double celsius){
        double fahrenheit = (celsius * 9.0/5.0) + 32;
        System.out.println(celsius + " degrees C is " + fahrenheit + " degrees F.");

        return fahrenheit;
    }

    static double fahrenheitToCelsius(double fahrenheit){
        double celsius = (fahrenheit - 32) * 5.0/9.0;
        System.out.println(celsius + " degrees F is " + fahrenheit + " degrees C.");

        return celsius;
    }
}

public class Utility {

    public static String getAppName() {
        return "My Awesome App";
    }

    public String getInstanceId() {
        return "ID-12345";
    }

    public static void main(String[] args) {
        {
            System.out.println("App Name: " + Utility.getAppName());

            Utility utilInstance = new Utility();
            System.out.println("Instance ID: " + utilInstance.getInstanceId());
        }

        System.out.println("");
        {
            double converted = Converter.celsiusToFahrenheit(25);
            converted = Converter.fahrenheitToCelsius(77);
        }
    }
}
