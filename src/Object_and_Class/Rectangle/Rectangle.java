package Object_and_Class.Rectangle;

import java.util.Scanner;

public class Rectangle {
    // 定义成员变量
    private double width;   // 矩形的宽度
    private double height;  // 矩形的高度

    // 构造函数
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 获取周长的方法
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // 获取面积的方法
    public double getArea() {
        return width * height;
    }

    // Getter和Setter方法（虽然不是题目要求，但良好实践）
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入矩形的宽度和高度
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        // 创建矩形对象
        Rectangle rectangle = new Rectangle(width, height);

        // 调用方法计算周长和面积，并格式化输出
        double perimeter = rectangle.getPerimeter();
        double area = rectangle.getArea();

        // 输出保留2位小数
        System.out.printf("%.2f, %.2f", perimeter, area);

        scanner.close();
    }
}
