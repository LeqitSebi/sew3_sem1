package Hutter.ue04_Rekursion;

public class Longest_Collatz_Sequence {
    public static void main(String[] args) {
        System.out.println(lösung(13, 0));
    }

    public static int lösung(int n, int zähler) {
        System.out.println(n);
        zähler++;
        if (n == 1) {
            return zähler;
        } else if (n % 2 == 1) {
            return lösung(3 * n + 1, zähler);
        } else if (n % 2 == 0) {
            return lösung(n / 2, zähler);
        }
        return zähler;
    }
}
