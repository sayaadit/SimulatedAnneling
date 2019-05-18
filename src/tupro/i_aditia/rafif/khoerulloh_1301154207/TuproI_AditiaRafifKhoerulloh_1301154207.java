/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupro.i_aditia.rafif.khoerulloh_1301154207;

/**
 *
 * @author aditiarafifkh
 */
public class TuproI_AditiaRafifKhoerulloh_1301154207 {
    
    public static double evaluate(double x1, double x2){
        double hasil = ((4-(2.1*(x1*x1))+((x1*x1*x1*x1)/3))*(x1*x1)) + (x1*x2) + ((-4+(4*(x2*x2)))*(x2*x2));
        return hasil;
    }
    
    public static double generate(){
        double x = Math.random()*10;
        int minus = (int) Math.random()*3;
        if(minus == 1){
            x = x * -1;
        }
        return x;
    }
    
    public static double generateNew(double x){
        double pengubah = Math.random()*1;
        if(x > 0){
            x = x - pengubah;
        } else{
            x = x + pengubah;
        }
        return x;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double cx1 = generate();
        double cx2 = generate();
        double bx1 = cx1;
        double bx2 = cx2;
        double Eb = evaluate(bx1, bx2);
        
        int T=100;
        while (T > 0) {
            double nx1 = generateNew(cx1);
            double nx2 = generateNew(cx2);
            double En=evaluate(nx1, nx2);
            double Ec=evaluate(cx1, cx2);
            double dE= En-Ec;
            if (dE<0){
                cx1=nx1;
                cx2=nx2;
                if (En<Eb){
                    bx1=cx1;
                    bx2=cx2;
                    Eb=Ec;
                }
            }
            else {
                int r = (int) Math.random()*T;
                if (r < Math.exp(-dE/T)){
                    cx1=nx1;
                    cx2=nx2;
                }
            }
            T = T-1;
        }
        System.out.println("Eb = " +Eb);
    }    
}
