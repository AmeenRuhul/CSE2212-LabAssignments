import java.io.*;
import java.math.*;


public class TheCalculator {

    int evaluatedValue;
    String operator;
    String expression;
    int constant1;
    int constant2;
    int pos = 0;


    public static void main(String[] args){
        System.out.println("Input form: constant operator constant");
        TheCalculator calculator = new TheCalculator();
        try{
            calculator.run();
        }catch(IOException e){
            System.out.println(e);
        }
        System.out.println("Bye, now.");
    }


    public void run() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(">");
        while((expression = br.readLine()) != null){
            String[] things = expression.split(" ");
            if (things.length != 3){
                System.out.println("Invalid operation");
                System.out.print(">");
                continue;
            }
            try{
                constant1 = Integer.parseInt(things[0]);
                if(constant1 == 0)
                    return;
                constant2 = Integer.parseInt(things[2]);
                operator = things[1];
            }catch(Exception e){
                System.out.println("invalid input");
                System.out.print(">");
                continue;
            }
            if(operator.equals("/") && constant2 == 0){
                System.out.println("Math error!");
                continue;
            }
            switch(operator){
                case "+": evaluatedValue = constant1 + constant2;
                    break;
                case "-": evaluatedValue = constant1 - constant2;
                    break;
                case "*": evaluatedValue = constant1 * constant2;
                    break;
                case "/": evaluatedValue = constant1 / constant2;
                    break;
                case "%": evaluatedValue = constant1 % constant2;
                    break;
                case "^": evaluatedValue = (int) Math.pow(constant1, constant2);
                    break;
                default: System.out.println("Wrong input form");
                    continue;
            }
            System.out.println(evaluatedValue);
            System.out.print(">");
        }
    }
}