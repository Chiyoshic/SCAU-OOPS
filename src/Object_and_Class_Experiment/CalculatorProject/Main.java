package Object_and_Class_Experiment.CalculatorProject;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Arithmetic expression = new Arithmetic(input);

        System.out.println(expression.getResult());

        scanner.close();
    }
}
