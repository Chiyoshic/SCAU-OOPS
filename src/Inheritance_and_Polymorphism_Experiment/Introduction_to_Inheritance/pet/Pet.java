package Inheritance_and_Polymorphism_Experiment.Introduction_to_Inheritance.pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pet {
    private String name;
    private LocalDate birthday;

    public Pet(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String shout() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String formattedDate = birthday.format(formatter);
        return "名字：" + name + "，生日：" + formattedDate;
    }
}
