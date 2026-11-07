import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double a, b, answer;
        int choice;

        System.out.println("SIMPLE CALCULATOR");
        System.out.println("1. Arithmetic");
        System.out.println("2. Trigonometry");
        System.out.println("3. Ratios");
        System.out.println("4. History");

        System.out.print("Choose: ");
        choice = input.nextInt();

        if (choice == 1) {
            System.out.print("Enter first number: ");
            a = input.nextDouble();

            System.out.print("Enter second number: ");
            b = input.nextDouble();

            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");

            int op = input.nextInt();

            if (op == 1)
                answer = a + b;
            else if (op == 2)
                answer = a - b;
            else if (op == 3)
                answer = a * b;
            else
                answer = a / b;

            System.out.println("Answer = " + answer);
        }

        else if (choice == 2) {
            System.out.print("Enter angle: ");
            a = input.nextDouble();

            System.out.println("sin = " + Math.sin(Math.toRadians(a)));
            System.out.println("cos = " + Math.cos(Math.toRadians(a)));
            System.out.println("tan = " + Math.tan(Math.toRadians(a)));
        }

        else if (choice == 3) {
            System.out.print("Enter first number: ");
            a = input.nextDouble();

            System.out.print("Enter second number: ");
            b = input.nextDouble();

            System.out.println("Ratio = " + a + ":" + b);
        }

        else if (choice == 4) {
            System.out.println("Calculation History");
            System.out.println("History will show previous calculations.");
        }

        else {
            System.out.println("Invalid choice");
        }
    }
}
