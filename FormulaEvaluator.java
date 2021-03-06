import java.util.Scanner; 
import java.text.DecimalFormat;
/**
 * This program computes the value generated by
 * a specified expression using the user's input
 * for the value of x and shows the amount of 
 * numbers to the right and left of the decimal
 * while also formatting the result.
 * Project 03.
 * 
 * @author Trisha Sengupta - section 001
 * @version 9/16/2015
 */


public class FormulaEvaluator {
   /**
    * Uses user's x value to evaluate expression
    * and prints digits left and right of decimal.
    * Formats result.
    *
    * @param args Command line arguments (not used).
   */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      double x = 0;
      double result = 0;
      String answer = "";
      int answerLength = 0;
      int indexOfDecimal = 0;
      int leftDecimal = 0;
      int rightDecimal = 0;
      
      // Asks user to enter value:
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
     
      // Calculates expression using x:
      result = Math.pow((9 * Math.pow(x, 3) + 7 * Math.pow(x, 2) 
            + 5 * x + 3), 2) * Math.sqrt((8 * Math.pow(x, 4) - 6 
               * Math.pow(x, 3) + 4 * Math.pow(x, 2) + Math.abs(20 * x) + 1));
      
      // Prints result:
      System.out.println("Result: " + result);
      
      // Determines the amount of numbers to the left
      // and right of decimal point: 
      answer = Double.toString(result);
      answerLength = answer.length();
      indexOfDecimal = answer.indexOf(".");
      leftDecimal = indexOfDecimal;
      rightDecimal = answerLength - indexOfDecimal - 1;
      
      // Prints decimal results:
      System.out.println("# digits to left of decimal point: " + leftDecimal);
      System.out.println("# digits to right of decimal point: " + rightDecimal);
      
      // Formats the result:
      DecimalFormat dFmt = new DecimalFormat("#,##0.0##");
      
      // Prints formatted result:
      System.out.println("Formatted Result: " + dFmt.format(result));
   
      
      
   }
}