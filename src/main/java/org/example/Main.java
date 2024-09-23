package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int selection;
        boolean shouldExit = false;
        double operand1, operand2 = 0; // operand2 only needed for power

        log.info("Application execution started");

        System.out.println("---- Scientific Calculator ----");

        while (!shouldExit) {
            showMenu();
            selection = input.nextInt();

            if (selection == 5) {
                shouldExit = true;
                System.out.println("Goodbye! Exiting now.");
                log.info("Exiting the calculator");
            } else {
                if (selection == 1) { // Power needs two operands
                    System.out.print("Enter the base number: ");
                    operand1 = input.nextDouble();
                    System.out.print("Enter the exponent: ");
                    operand2 = input.nextDouble();
                } else { // All others need one operand
                    System.out.print("Enter the number: ");
                    operand1 = input.nextDouble();
                }

                double result = 0;

                switch (selection) {
                    case 1:
                        log.info("Executing Power operation with base: " + operand1 + " and exponent: " + operand2);
                        result = power(operand1, operand2);
                        break;
                    case 2:
                        log.info("Executing Square Root operation for: " + operand1);
                        result = squareRoot(operand1);
                        break;
                    case 3:
                        log.info("Executing Factorial operation for: " + (int) operand1);
                        result = factorial((int) operand1);
                        break;
                    case 4:
                        log.info("Executing Natural Logarithm operation for: " + operand1);
                        result = naturalLogarithm(operand1);
                        break;
                    default:
                        log.error("Invalid selection: " + selection);
                        System.out.println("Invalid option! Please choose a valid option.");
                        continue;
                }

                if (selection >= 1 && selection <= 4) {
                    System.out.println("Result: " + result);
                    log.info("Operation Result: " + result);
                }
            }
        }

        log.info("Application execution finished");
        input.close();
    }

    public static void showMenu() {
        System.out.println("\nSelect an operation:");
        System.out.println("1. Power");
        System.out.println("2. Square Root");
        System.out.println("3. Factorial");
        System.out.println("4. Natural Logarithm");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
    }

    public static double power(double base, double exponent) {
        double result = Math.pow(base, exponent);
        log.info("Power operation result: " + result);
        return result;
    }

    public static double squareRoot(double number) {
        if (number < 0) {
            log.error("Error: Square root of a negative number is not defined. Input: " + number);
            System.out.println("Error: Square root of a negative number is not defined.");
            return Double.NaN;
        }
        double result = Math.sqrt(number);
        log.info("Square root result: " + result);
        return result;
    }

    public static long factorial(int number) {
        if (number < 0) {
            log.error("Error: Factorial of a negative number is not defined. Input: " + number);
            System.out.println("Error: Factorial of a negative number is not defined.");
            return -1;
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        log.info("Factorial result: " + result);
        return result;
    }

    public static double naturalLogarithm(double number) {
        if (number <= 0) {
            log.error("Error: Logarithm of a non-positive number is not defined. Input: " + number);
            System.out.println("Error: Logarithm of a non-positive number is not defined.");
            return Double.NaN;
        }
        double result = Math.log(number);
        log.info("Natural logarithm result: " + result);
        return result;
    }
}
