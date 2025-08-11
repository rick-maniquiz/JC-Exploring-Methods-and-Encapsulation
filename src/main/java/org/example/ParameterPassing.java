package org.example;

class Student{
    String name;

    Student(String name){
        this.name = name;
    }

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }
}

public class ParameterPassing {
    public static void modifyValue(int value) {
        value = 100;
        System.out.println("Inside method: " + value);
    }

    public static void changeStudentName(Student student, String newName){
        student.setName(newName);
    }

    public static void main(String[] args) {
        {
            int originalValue = 50;
            System.out.println("Before method call: " + originalValue);
            modifyValue(originalValue);
            System.out.println("After method call: " + originalValue);
            System.out.println();
        }

        {
            Student student = new Student("Alex");
            System.out.println("Name before change: " + student.getName());
            changeStudentName(student, "Jordan");
            System.out.println("Name after change: " + student.getName());
        }
    }
}
