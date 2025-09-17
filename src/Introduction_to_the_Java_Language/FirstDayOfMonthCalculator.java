package Introduction_to_the_Java_Language;

import java.util.Scanner;

public class FirstDayOfMonthCalculator {


    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int[] getDaysInMonth(int year) {
        return new int[]{31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    public static int[] calculate(int year, int firstDay) {
        int[] firstDays = new int[12];
        int[] daysInMonth = getDaysInMonth(year);
        firstDays[0] = firstDay; // 1月1日
        for (int i = 1; i < 12; i++) {
            firstDays[i] = (firstDays[i - 1] + daysInMonth[i - 1] % 7) % 7;
        }

        return firstDays;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int firstDay = scanner.nextInt();

        if (year <= 0 || firstDay < 0 || firstDay > 6) {
            System.out.println("不正确的输入");
            return;
        }

        int[] firstDays = calculate(year, firstDay);

        for (int day : firstDays) {
            System.out.print(day + " ");
        }
    }
}
