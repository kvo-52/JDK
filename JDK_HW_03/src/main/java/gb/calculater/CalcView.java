package gb.calculater;

import java.util.Scanner;
//import gb.calculater.Calculator;
public class CalcView {
    public void calculateView(){
        Scanner scanner = new Scanner(System.in);
        CalcView calculator = new CalcView();
        System.out.println("Enter the first number: ");
        Integer inputFirstNumber = scanner.nextInt();
        System.out.println("Enter the second number: ");
        Integer inputSecondNumber = scanner.nextInt();
        System.out.println("Enter operator (+, -, *, /):");
        char operation = scanner.next().charAt(0);
        while (true){
            switch (operation){
                case '+':
                    System.out.println("Result: " + Calculator.calculator.add(inputFirstNumber, inputSecondNumber));
                    break;
                case '-':
                    System.out.println("Result: " + Calculator.calculator.subtract(inputFirstNumber, inputSecondNumber));
                    break;
                case '*':
                    System.out.println("Result: " + Calculator.calculator.multiply(inputFirstNumber, inputSecondNumber));
                    break;
                case '/':
                    System.out.println("Result: " + Calculator.calculator.div(inputFirstNumber, inputSecondNumber));
                    break;
                default:
                    System.out.println("Not a correct character");
            }
            System.out.println("Do you want to continue? (Y/N)");
        }
    }


}
