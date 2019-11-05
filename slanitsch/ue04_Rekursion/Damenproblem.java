package slanitsch.ue04_Rekursion;

import java.util.Scanner;

public class Damenproblem {
    /**
     * Aufruf des Damenproblems.
     * @param args nicht verwendet.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("n-Damen-Problem");
        System.out.println();
        System.out.print("n: ");
        int n = in.nextInt();
        int[] q = queens(n);
        print(q);

    }

    /**
     * Berechnet eine Loesung des N-Damen-Problems.
     * Die Position in x-y-Richtung wird jeweils ab 0 gezaehlt.
     *
     * @param n Anzahl der Damen.
     * @return Array mit den Positionen.
     */
    public static int[] queens(int n) {
        int[] q = new int[n];
        queens(q, 0);
        return q;
    }

    /**
     * Gibt eine Loesung für das in den ersten col
     * Spalten gefuellte Feld? Wenn es eine Loesung gibt, ist das Feld qs
     * vollstaendig mit den korrekten Positionen gefuellt.
     *
     * @param qs Array der Damen-Positionen.
     * @param col Anzahl der bereits gesetzen Spalten.
     * @return <tt>true</tt> wenn es eine Loesung gibt.
     */
    private static boolean queens(int[] qs, int col) {
        if (col == qs.length)
            return true;
        // finde die Erstbeste passende Zeile (row)
        for (int row = 0; row < qs.length; row++) {
            if (isSafe(qs, row, col)) {
                qs[col] = row;
                // wenn auch der Rest gesetzt werden kann,
                // sind wir fertig
                if (queens(qs, col+1)) return true;
            }
        }
        return false;
    }

    /**
     * Steht die neue Dame auf der Position row,col sicher, so dass Sie
     * nicht von den anderen zuvor gesetzten Damen in den Spalten
     * 0 bis col-1 geschlagen werden kann?
     *
     * @param qs Array der Damenpositionen
     * @param row Zeile der neuen Dame
     * @param col Position der neuen Dame
     * @return <tt>true</tt> wenn die neue Dame sicher steht.
     */
    private static boolean isSafe(int[] qs, int row, int col) {
        int up = row;
        int down = row;
        boolean isStillSafe = true;
        for (int c = col-1; isStillSafe && c >= 0; c--) {
            int r = qs[c];
            isStillSafe = r != row && r != ++up && r != --down;
        }
        return isStillSafe;
    }

    /**
     * Gibt die Damenpositionen aus.
     *
     * @param qs Damenpositionen.
     */
    private static void print(int[] qs) {
        System.out.printf("Lösung: ");
        for (int i = 0; i < qs.length; i++)
            System.out.printf("%4d", qs[i]+1);
        System.out.printf("%n");
    }
}
