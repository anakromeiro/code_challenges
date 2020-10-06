/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Karol
 */
public class Day1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        
        DecimalFormat df = new DecimalFormat(".#");        
        int iAux;
        double dAux;
        String sAux;
		
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);       
        
        iAux = Integer.parseInt(scan.nextLine());
        dAux = Double.parseDouble(scan.nextLine());
        sAux = scan.nextLine();       
        
        System.out.println(i+iAux);
        System.out.println(df.format(d+dAux));
        System.out.println(s+sAux);
        
        scan.close();
    }
    
}
