package edu.cnm.deepdive;

import java.util.Stack;

/**
 * This is the class containing the main entry point for the (eventual) RPN calculator.
 * 
 * @author Justin Torrez
 * @version 0.2
 *
 */

public class RpnCalculator {

  private RpnCalculator() {}

  /**
   * Command line entry point for RPN interpreter.
   * 
   * @param args something goes here
   */
  public static void main(String[] args) {
    Stack<Double> stack = new Stack<>();
    for (String arg : args) {
      arg = arg.trim().toLowerCase();
      
      switch (arg) {
        // Switch for method call
        case "add":
        case "+":
          add(stack);
          break;
        case "sub":
        case "-":
         subtract(stack);
          break;
        case"mul":
        case "*":
          multiply(stack);
          break;
        case "div":
        case "/":
          divide(stack);
          break;
        case "exp":
        case "^":
         power(stack);
          break;
        case "abs":
          abs(stack);
          break;
        case "log":
          log10(stack);
          break;
        case "pop":
          stack.pop();
          break;
        case "idiv":
        case "\\":
          idiv(stack);
          break;
        case "swap":
          swap(stack);
          break;
          default:
          stack.push(Double.valueOf(arg));
          break;
      }
    }
    if (stack.empty()) {
      System.out.println("Stack is empty.");
    } else {
      System.out.printf("Result = %,.2f", stack.pop());
    }
  }

  /**
   * @param stack
   */
  private static void add(Stack<Double> stack) {
    double [] values = pop(stack, 2);
    stack.push(values[0] + values[1]);
  }
  private static void subtract(Stack<Double> stack) {
    double [] values = pop(stack, 2);
    stack.push(values[0] - values[1]);
  }
  private static void multiply(Stack<Double> stack) {
    double [] values = pop(stack, 2);
    stack.push(values[0] * values[1]);
  }

  private static void divide(Stack<Double> stack) {
    double [] values = pop(stack, 2);
    stack.push(values[0] / values[1]);
  }

  private static void power(Stack<Double> stack) {
    double[] values = pop(stack, 2);
    stack.push(Math.pow(values[0], values[1]));
  }

    private static void abs(Stack<Double> stack){
      double value = stack.pop();
      stack.push(Math.abs(value));
  }

  private static void log10(Stack<Double> stack) {
    double value = stack.pop();
    stack.push(Math.log10(value));
    }

  private static void idiv(Stack<Double> stack) {
    double[] values = pop(stack, 2);
    double result = values[0] / values [1];
    double quotient = Math.floor(result);
    double remainder =  values[0] - values[1] * quotient;
    stack.push(remainder);
    stack.push(quotient);
  }

  private static void swap(Stack<Double> stack) {
    double[] values = pop(stack, 2);
    stack.push(values[0]);
    stack.push(values[1]);
  }

  private static double[] pop (Stack<Double> stack, int numItems) {
   double[] values =  new double [numItems];
   for (int i=0; i < numItems; i++) {
     values[i] = stack.pop(); 
   }
   return values; 
  }
}
