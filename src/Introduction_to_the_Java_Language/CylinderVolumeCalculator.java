package Introduction_to_the_Java_Language;

import java.util.Scanner;

public class CylinderVolumeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        double height = scanner.nextDouble();
        double volume = Math.PI * radius * radius * height;
        System.out.printf("%.2f", volume);
        scanner.close();
    }
}
