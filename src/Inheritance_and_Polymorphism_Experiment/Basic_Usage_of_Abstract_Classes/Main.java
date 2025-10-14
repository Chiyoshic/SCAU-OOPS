package Inheritance_and_Polymorphism_Experiment.Basic_Usage_of_Abstract_Classes;

import Inheritance_and_Polymorphism_Experiment.Basic_Usage_of_Abstract_Classes.device.ElectricalDevice;
import Inheritance_and_Polymorphism_Experiment.Basic_Usage_of_Abstract_Classes.device.Fan;
import Inheritance_and_Polymorphism_Experiment.Basic_Usage_of_Abstract_Classes.device.Light;

public class Main {
    public static void main(String[] args) {
        Light light = new Light("客厅灯");
        Fan fan = new Fan("客厅风扇");
        System.out.println(light.getStatus());
        System.out.println(fan.getStatus());

        light.powerOn();
        fan.powerOn();
        fan.adjustSpeed(3);
        System.out.println(light.getStatus());
        System.out.println(fan.getStatus());

        ElectricalDevice[] devices = { light, fan };
        for (ElectricalDevice device : devices) {
            device.powerOff();
        }
    }
}
