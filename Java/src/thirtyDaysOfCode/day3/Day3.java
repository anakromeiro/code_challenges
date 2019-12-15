/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3;

import java.util.Scanner;

/**
 *
 * @author Karol
 */
public class Day3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      int n = scan.nextInt(); 
      scan.close();
      String ans="";
          
      // if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
      if(n%2==1){
         ans = "Weird";
      } else if (2 <= n && n <= 5) {
         ans = "Not Weird";
      } else if (6 <= n && n <= 20){
          ans = "Weird";
      } else{
          ans = "Not Weird";
      }
      System.out.println(ans);
   }    
}
