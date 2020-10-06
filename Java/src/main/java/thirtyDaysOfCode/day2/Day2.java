/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2;

import java.util.Scanner;

/**
 *
 * @author Karol
 */
public class Day2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        double tipCost, percentCost, totalCostD;
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();
      
        // Write your calculation code here.
        tipCost = (mealCost * ((double)tipPercent/100.0));        
        percentCost = mealCost * ((double)taxPercent/100.0);
        totalCostD = mealCost + tipCost + percentCost;
      
        // cast the result of the rounding operation to an int and save it as totalCost 
        int totalCost = (int) Math.round(totalCostD);
      
        // Print your result
        System.out.println("The total meal cost is " + Math.round(totalCost) + " dollars.");
        */
        
        double mealCost, tipCost, percentCost, totalCost;
        int tipPercent, taxPercent;
        
        Scanner scan = new Scanner(System.in);
        
        mealCost = Double.parseDouble(scan.nextLine());
        tipPercent = Integer.parseInt(scan.nextLine());
        taxPercent = Integer.parseInt(scan.nextLine());
        
        tipCost = (mealCost * ((double)tipPercent/100.0));        
        percentCost = mealCost * ((double)taxPercent/100.0);
        totalCost = mealCost + tipCost + percentCost;
        
        System.out.println("The total meal cost is " + Math.round(totalCost) + " dollars.");
    }
    
}
