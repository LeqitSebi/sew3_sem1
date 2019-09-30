package slanitsch.ue01_collectionbonus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class PathEndComparator implements Comparator<Path> {
    @Override
    public int compare(Path o1, Path o2) {
        System.out.println((int) o1.getFileName().toString().split("[.]")[1].toLowerCase().toCharArray()[0]);

        char[] a1 = o1.getFileName().toString().split("[.]")[1].toLowerCase().toCharArray();
        char[] a2 = o2.getFileName().toString().split("[.]")[1].toLowerCase().toCharArray();

        int longest = Math.max(a1.length, a2.length);
        int shortest = Math.min(a1.length, a2.length);

        for (int i = 0; i < longest; i++) {
            if (i <= shortest) {
                if ((int) a1[i] > (int) a2[i]) {
                    return 1;

                } else if ((int) a1[i] == (int) a2[i]) {
                    return 0;

                }
            }
        }
        return -1;
    }
}