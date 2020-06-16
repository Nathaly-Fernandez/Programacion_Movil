/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logaritmo;

import java.util.Scanner;

/**
 *
 * @author niki_
 */
public class Logaritmo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        metodo met = new metodo();
        double e, total;
        int b;
        System.out.println("ingrese base");
        b=reader.nextInt();
        System.out.println("ingrese numeroe");
        e=reader.nextDouble();
       total= met.log(b,e);
        
       System.out.println(total);
        
        // TODO code application logic here
    }
    
}
