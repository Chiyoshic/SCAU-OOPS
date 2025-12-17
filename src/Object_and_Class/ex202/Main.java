package Object_and_Class.ex202;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入矩形的宽度和高度
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        // 调用无参构造方法创建矩形对象
        Rectangle rectangle1 = new Rectangle();
        // 输出无参构造创建的矩形周长和面积
        System.out.printf("%.2f, %.2f%n", rectangle1.getPerimeter(), rectangle1.getArea());

        // 调用有参构造方法创建矩形对象，使用输入值作为构造方法参数
        Rectangle rectangle2 = new Rectangle(width, height);
        // 输出有参构造创建的矩形周长和面积
        System.out.printf("%.2f, %.2f", rectangle2.getPerimeter(), rectangle2.getArea());

        scanner.close();
    }
}
