package edu.cnm.deepdive;

import java.util.Stack;

/**
 * This is the class containing the main entry point for the (eventual) RPN calculator.
 * 
 * @author Justin Torrez
 */

public class Summation {

  /**
   * Command line entry point for RPN interpreter.
   * 
   * @param args something goes here
   */
  public static void main(String[] args) {
    Stack<Double> stack = new Stack<>();
    for (int i = 0; i < args.length; i++) {
      String arg = args[i];
      arg = arg.trim().toLowerCase();
      /*
       * if (arg.equals("+")) { 
       * double val1 = stack.pop(); double val2 = stack.pop();
       * stack.push(val1 + val2); } 
       * 
       * else if (arg.equals("-")) { 
       * double val1 = stack.pop(); double
       * val2 = stack.pop(); stack.push(val1 - val2); } 
       * else if (arg.equals("*")) { 
       * double val1 =
       * stack.pop(); double val2 = stack.pop(); stack.push(val1 * val2); } 
       * else { 
       * double val = Double.parseDouble(args[i]); stack.push(val); }
       */
      double val1;
      double val2;
      switch (arg) {
        // FIXME - Replace repeated statements with method call
        case "add":
        case "+":
          val1 = stack.pop();
          val2 = stack.pop();
          stack.push(val1 + val2);
          break;
        case "sub":
        case "-":
          val1 = stack.pop();
          val2 = stack.pop();
          stack.push(val1 - val2);
          break;
        case"mul":
        case "*":
          val1 = stack.pop();
          val2 = stack.pop();
          stack.push(val1 * val2);
          break;
        case "div":
        case "/":
          val1 = stack.pop();
          val2 = stack.pop();
          stack.push(val1 / val2);
          break;
        case "exp":
        case "^":
          val1 = stack.pop();
          val2 = stack.pop();
          stack.push(Math.pow(val1, val2));
          break;
        default:
          val1 = Double.parseDouble(args[i]);
          stack.push(val1);
          break;
      }
    }
    System.out.printf("Result = %,.2f", stack.pop());
  }

}
