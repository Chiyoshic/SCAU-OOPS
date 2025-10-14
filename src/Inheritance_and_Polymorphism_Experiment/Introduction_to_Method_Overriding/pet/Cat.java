package Inheritance_and_Polymorphism_Experiment.Introduction_to_Method_Overriding.pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cat extends Pet {
    public Cat(String name, LocalDate birthday) {
        super(name, birthday); // 调用父类构造方法
    }

    @Override
    public String shout() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String formattedDate = getBirthday().format(formatter);
        return "猫，名字：" + getName() + "，生日：" + formattedDate;
    }

    public String climbTree() {
        return "我会爬树";
    }
}
