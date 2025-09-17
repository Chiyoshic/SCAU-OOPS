package Introduction_to_the_Java_Language;

import java.util.Scanner;

public class PalindromeNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= 0) {
            System.out.println("不正确的输入");
        } else {
            int reversedNumber = 0;
            int originalNumber = number;
            while (number > 0) {
                int digit = number % 10;
                reversedNumber = reversedNumber * 10 + digit;
                number /= 10;
            }
            if (originalNumber == reversedNumber) {
                System.out.println(originalNumber + "是回文整数");
            } else {
                System.out.println(originalNumber + "不是回文整数");
            }
        }
        scanner.close();
    }
}
