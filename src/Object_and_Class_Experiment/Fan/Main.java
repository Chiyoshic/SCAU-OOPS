package Object_and_Class_Experiment.Fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入风扇品牌
        System.out.print("输入品牌: ");
        String brand = scanner.nextLine();

        Fan fan = new Fan(brand);

        System.out.println("品牌: " + fan.getBrand());
        System.out.println("运行: " + (fan.isOn() ? "是" : "否"));
        System.out.println("速度: " + fan.getSpeedString());

        fan.setOn(true);
        System.out.println("品牌: " + fan.getBrand());
        System.out.println("运行: " + (fan.isOn() ? "是" : "否"));
        System.out.println("速度: " + fan.getSpeedString());

        fan.setSpeed(Fan.FAST);
        System.out.println("品牌: " + fan.getBrand());
        System.out.println("运行: " + (fan.isOn() ? "是" : "否"));
        System.out.println("速度: " + fan.getSpeedString());

        scanner.close();
    }
}
