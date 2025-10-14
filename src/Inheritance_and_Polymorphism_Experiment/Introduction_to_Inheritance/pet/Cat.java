package Inheritance_and_Polymorphism_Experiment.Introduction_to_Inheritance.pet;

import java.time.LocalDate;

public class Cat extends Pet{
    public Cat(String name, LocalDate birthday) {
        super(name, birthday); // 调用父类构造方法
    }

    public String climbTree() {
        return "我会爬树";
    }
}
