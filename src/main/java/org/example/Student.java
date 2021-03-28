package org.example;

public class Student {
    private String name;
    public Student(String name)
    {
        this.name = name;
    }
    public void setStudentName(String newName)
    {
        this.name = newName;
    }
    public String getStudentName()
    {
        return this.name;
    }
    public void makeCoffee(Sugar sugar, Coffee coffee, Kettle kettle, Cup cup) throws InterruptedException {
        sugar.pour(cup);
        coffee.pour(cup);
        kettle.fillWithWater(cup);
    }
}
