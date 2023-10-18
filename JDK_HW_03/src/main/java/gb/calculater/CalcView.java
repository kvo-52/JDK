package gb.calculater;

import java.util.Scanner;
public class CalcView {
    public void calculateView(){
        Scanner scanner = new Scanner(System.in);
        CalcView calculator = new CalcView();
        System.out.println("Enter the first number: ");
        double inputFirstNumber = scanner.nextDouble();
        System.out.println("Enter the second number: ");
        double inputSecondNumber = scanner.nextDouble();
        System.out.println("Enter operator (+, -, *, /):");
        char operation = scanner.next().charAt(0);
        while (true){
            switch (operation){
                case '+':
                    System.out.println("Result: " + calculator.add(inputFirstNumber, inputSecondNumber));
                    break;
                case '-':
                    System.out.println("Result: " + calculator.subtract(inputFirstNumber, inputSecondNumber));
                    break;
                case '*':
                    System.out.println("Result: " + calculator.multiply(inputFirstNumber, inputSecondNumber));
                    break;
                case '/':
                    System.out.println("Result: " + calculator.div(inputFirstNumber, inputSecondNumber));
                    break;
                default:
                    System.out.println("Not a correct character");
            }
//            System.out.println("Do you want to continue? (Y/N)");
        }
    }


}
