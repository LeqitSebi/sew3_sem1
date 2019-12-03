package Hutter.ue04_Rekursion;

public class ZweiHoch {
    public static void main(String[] args) {
        System.out.println(potenz(2,3));
    }
    public static double potenz(double zahl, int pot) {
        if (pot==1) {
            return zahl;
        } else {
            return zahl*potenz(zahl,pot-1);
        }
    }


}
