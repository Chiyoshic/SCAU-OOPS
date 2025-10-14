package Inheritance_and_Polymorphism_Experiment.Introduction_to_Method_Overriding.pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dog extends Pet {
    public Dog(String name, LocalDate birthday) {
        super(name, birthday); // 调用父类构造方法
    }

    @Override
    public String shout() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String formattedDate = getBirthday().format(formatter);
        return "狗，名字：" + getName() + "，生日：" + formattedDate;
    }

    public String guard() {
        return "我能警戒";
    }
}
