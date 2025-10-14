package Inheritance_and_Polymorphism_Experiment.Introduction_to_Inheritance.pet;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String name, LocalDate birthday) {
        super(name, birthday); // 调用父类构造方法
    }

    public String guard() {
        return "我能警戒";
    }
}
