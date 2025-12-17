package Object_and_Class.ex202;

public class Rectangle {
    // 定义成员变量
    private double width;   // 矩形的宽度
    private double height;  // 矩形的高度

    // 无参构造方法：把矩形的宽度和高度初始化为1.0
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    // 有参构造方法：用参数初始化矩形宽度和高度
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
}
