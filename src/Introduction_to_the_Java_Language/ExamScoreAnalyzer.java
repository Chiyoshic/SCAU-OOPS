package Introduction_to_the_Java_Language;

import java.util.Scanner;

public class ExamScoreAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double[][] scores = new double[n][];

        for (int i = 0; i < n; i++) {
            int numStudents = scanner.nextInt();
            scores[i] = new double[numStudents];
            for (int j = 0; j < numStudents; j++) {
                scores[i][j] = scanner.nextDouble();
            }
        }

        for (int i = 0; i < n; i++) {
            double sum = 0;
            double max = scores[i][0];
            double min = scores[i][0];

            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
                if (scores[i][j] > max) {
                    max = scores[i][j];
                }
                if (scores[i][j] < min) {
                    min = scores[i][j];
                }
            }

            double avg = sum / scores[i].length;

            System.out.printf("%.2f %.2f %.2f%n", avg, max, min);
        }

        scanner.close();
    }
}
