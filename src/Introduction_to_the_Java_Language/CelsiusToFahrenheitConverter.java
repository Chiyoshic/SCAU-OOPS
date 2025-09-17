package Introduction_to_the_Java_Language;

import java.util.Scanner;

public class CelsiusToFahrenheitConverter {
    public static double tempConverting(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double celsius = sc.nextDouble();
        double fahrenheit = tempConverting(celsius);
        System.out.printf("%.2f%n", fahrenheit);   // 保留两位小数
        sc.close();
    }
}
