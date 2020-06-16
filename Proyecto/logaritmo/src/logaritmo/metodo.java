/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logaritmo;

/**
 *
 * @author niki_
 */
public class metodo {
    public double log(int b,double n) {
    double val = 0;
    int i,accurate = 10,reps=0;
    while(n != 1 && accurate>=0) {
        for(i=0;n>=b;i++) n /= b;
            n = p(n,10);
            val = 10*(val+i);
            accurate--; reps++;
    }
    return (double)val/p(10,reps);
}
    public double p(double x,int i) {
    double r = 1.0;
    r= Math.pow(x, i);
    return r;
}
    
}
