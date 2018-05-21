package edu.cnm.deepdive;

public class Summation {

  public static void main(String[] args) {
//    System.out.println(args[0]);
//    System.out.println(args[1]);
//    System.out.println(args.length);
    int sum = 0; 
    for (int i = 0; i < args.length; i++) {
      int val = Integer.parseInt(args[i]);
//      sum = sum + val;
      sum += val;
//      System.out.println(args[i]);
    }
    System.out.println(sum);
  }

}
